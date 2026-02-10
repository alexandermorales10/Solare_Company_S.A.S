package com.MoralexCorpSolare_Company_SAS.payment.impl;

import com.MoralexCorpSolare_Company_SAS.entity.Pago;
import com.MoralexCorpSolare_Company_SAS.payment.dto.PaymentRequestDTO;
import com.MoralexCorpSolare_Company_SAS.payment.dto.PaymentResponseDTO;
import com.MoralexCorpSolare_Company_SAS.payment.dto.WebhookDTO;
import com.MoralexCorpSolare_Company_SAS.payment.service.PaymentService;
import com.MoralexCorpSolare_Company_SAS.repository.PagoRepository;
import com.MoralexCorpSolare_Company_SAS.integration.wompi.WompiClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final WompiClient wompiClient;
    private final PagoRepository pagoRepository;

    /**
     * Crear pago en Wompi y guardar registro en BD
     */
    @Override
    @Transactional
    public PaymentResponseDTO createPayment(PaymentRequestDTO requestDTO) {

        // 1️crear pago en Wompi
        PaymentResponseDTO wompiResponse = wompiClient.createTransaction(requestDTO);

        // 2️Guardar pago en base de datos
        Pago pago = new Pago();
        pago.setMonto(requestDTO.getMonto());
        pago.setMetodoPago(requestDTO.getMetodoPago().name());
        pago.setEstadoPago("PENDIENTE");
        pago.setTransactionId(wompiResponse.getTransactionIdWompi());

        pagoRepository.save(pago);

        return wompiResponse;
    }

    /**
     * Manejo del webhook enviado por Wompi
     */
    @Override
    @Transactional
    public void handleWebhook(WebhookDTO webhookDTO) {

        if (webhookDTO == null || webhookDTO.getData() == null) {
            return;
        }

        String transactionId = webhookDTO.getData().getTransaction().getId();
        String status = webhookDTO.getData().getTransaction().getStatus();

        Pago pago = pagoRepository
                .findByTransactionId(transactionId)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        // 3️Actualizar estado del pago
        pago.setEstadoPago(status);
        pagoRepository.save(pago);
    }
}
