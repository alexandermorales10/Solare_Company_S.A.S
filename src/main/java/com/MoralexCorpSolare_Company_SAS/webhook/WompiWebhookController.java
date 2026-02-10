package com.MoralexCorpSolare_Company_SAS.webhook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/webhook/wompi")
@Slf4j
public class WompiWebhookController {

    /**
     * Endpoint que Wompi llamará cuando cambie el estado de una transacción
     */
    @PostMapping
    public ResponseEntity<String> recibirEventoWompi(@RequestBody Map<String, Object> payload) {

        log.info("Webhook recibido desde Wompi: {}", payload);

        try {

            // Obtener datos principales del webhook
            Map<String, Object> eventData = (Map<String, Object>) payload.get("data");

            if (eventData != null) {

                Map<String, Object> transaction = (Map<String, Object>) eventData.get("transaction");

                if (transaction != null) {

                    String transactionId = (String) transaction.get("id");
                    String status = (String) transaction.get("status");
                    String reference = (String) transaction.get("reference");

                    log.info("Transacción ID: {}", transactionId);
                    log.info("Estado del pago: {}", status);
                    log.info("Referencia compra: {}", reference);

                    // 👉 Aquí debes conectar tu lógica de negocio
                    // Ejemplo:
                    // actualizarEstadoPago(reference, status);

                }
            }

            return ResponseEntity.ok("Webhook procesado correctamente");

        } catch (Exception e) {

            log.error("Error procesando webhook Wompi", e);
            return ResponseEntity.internalServerError().body("Error procesando webhook");
        }
    }
}
