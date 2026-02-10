package com.MoralexCorpSolare_Company_SAS.payment.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WebhookDTO {

    private String event;

    private TransactionData data;

    @Data
    public static class TransactionData {

        private Transaction transaction;
    }

    @Data
    public static class Transaction {

        private String id;                 // transactionId de Wompi
        private String status;             // APPROVED, DECLINED, ERROR, VOIDED
        private BigDecimal amountInCents;  // Wompi maneja centavos
        private String reference;          // Referencia de compra
        private String paymentMethodType;  // CARD, PSE, etc
        private LocalDateTime createdAt;
        private LocalDateTime finalizedAt;
    }
}
