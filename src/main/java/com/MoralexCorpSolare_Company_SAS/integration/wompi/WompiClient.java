package com.MoralexCorpSolare_Company_SAS.integration.wompi;

import com.MoralexCorpSolare_Company_SAS.entity.Pago;
import com.MoralexCorpSolare_Company_SAS.payment.dto.PaymentRequestDTO;
import com.MoralexCorpSolare_Company_SAS.payment.dto.PaymentResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class WompiClient {

    private final RestTemplate restTemplate;

    @Value("${wompi.url}")
    private String wompiUrl;

    @Value("${wompi.public.key}")
    private String publicKey;

    @Value("${wompi.private.key}")
    private String privateKey;

    public WompiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Obtener token o información de comercio
    public String obtenerInfoComercio() {

        String url = wompiUrl + "/merchants/" + publicKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    // Crear transacción (pago)
    public String crearTransaccion(Pago bodyJson) {

        String url = wompiUrl + "/transactions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(privateKey);

        HttpEntity<String> entity = new HttpEntity<>(bodyJson, headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    public PaymentResponseDTO createTransaction(PaymentRequestDTO requestDTO) {

        // URL sandbox Wompi (puedes cambiar a producción después)
        String url = "https://sandbox.wompi.co/v1/transactions";

        // Crear cliente HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Construir request para Wompi
        Map<String, Object> body = new HashMap<>();
        body.put("amount_in_cents", requestDTO.getMonto().multiply(new BigDecimal(100)).intValue());
        body.put("currency", "COP");
        body.put("customer_email", requestDTO.getEmailCliente());
        body.put("payment_method", Map.of(
                "type", requestDTO.getMetodoPago()
        ));
        body.put("reference", requestDTO.getReferenciaCompra());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("TU_PUBLIC_KEY_WOMPI"); // ⚠️ Cambiar

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

        Map data = (Map) response.getBody().get("data");

        // Construir ResponseDTO
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setTransactionIdWompi((String) data.get("id"));
        dto.setEstadoPago((String) data.get("status"));
        dto.setReferenciaCompra((String) data.get("reference"));

        return dto;
    }

}
