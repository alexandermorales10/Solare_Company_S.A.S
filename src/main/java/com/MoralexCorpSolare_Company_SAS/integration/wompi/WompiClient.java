package com.MoralexCorpSolare_Company_SAS.integration.wompi;

import com.MoralexCorpSolare_Company_SAS.dto.request.PagoRequestDTO;
import com.MoralexCorpSolare_Company_SAS.dto.response.PagoResponseDTO;
import com.MoralexCorpSolare_Company_SAS.entity.Pago;
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

    @Value("${wompi.url:}")
    private String wompiUrl;

    @Value("${wompi.public.key:}")
    private String publicKey;

    @Value("${wompi.private.key:}")
    private String privateKey;

    @Value("${wompi.enabled:false}")
    private boolean wompiEnabled;


    public WompiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Obtener información del comercio (solo si Wompi está activo)
    public String obtenerInfoComercio() {

        if (!wompiEnabled) {
            return "Modo simulación activo - Wompi deshabilitado";
        }

        String url = wompiUrl + "/merchants/" + publicKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    // Crear transacción usando entidad Pago
    public String crearTransaccion(Pago bodyJson) {

        if (!wompiEnabled) {
            return "SIM-" + System.currentTimeMillis();
        }

        String url = wompiUrl + "/transactions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(privateKey);

        HttpEntity<Pago> entity = new HttpEntity<>(bodyJson, headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    // Crear transacción usando DTO (Recomendado)
    public PagoResponseDTO createTransaction(PagoRequestDTO requestDTO) {

        // SIMULACIÓN SI WOMPI ESTÁ DESACTIVADO
        if (!wompiEnabled) {

            PagoResponseDTO dto = new PagoResponseDTO();
            dto.setReferenciaWompi("SIM-" + System.currentTimeMillis());
            dto.setEstado("APPROVED");
            dto.setReferencia(requestDTO.getReferencia());

            return dto;
        }

        String url = wompiUrl + "/transactions";

        Map<String, Object> body = new HashMap<>();
        body.put("amount_in_cents",
                requestDTO.getMonto().multiply(new BigDecimal(100)).intValue());
        body.put("currency", "COP");
        body.put("customer_email", requestDTO.getCorreoCliente());
        body.put("payment_method", Map.of(
                "type", requestDTO.getMetodoPago()
        ));
        body.put("reference", requestDTO.getReferencia());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(privateKey);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, request, Map.class);

        Map<String, Object> responseBody = response.getBody();

        if (responseBody == null) {
            throw new RuntimeException("Respuesta vacía de Wompi");
        }

        Map<String, Object> data =
                (Map<String, Object>) responseBody.get("data");

        PagoResponseDTO dto = new PagoResponseDTO();
        dto.setReferenciaWompi((String) data.get("id"));
        dto.setEstado((String) data.get("status"));
        dto.setReferencia((String) data.get("reference"));

        return dto;
    }
}
