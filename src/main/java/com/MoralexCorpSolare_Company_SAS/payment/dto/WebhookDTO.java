package com.MoralexCorpSolare_Company_SAS.payment.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WebhookDTO {

    private String event;

    private TransactionData data;

    public static class TransactionData {

        private Transaction transaction;

        public Transaction getTransaction() {
            return transaction;
        }

        public void setTransaction(Transaction transaction) {
            this.transaction = transaction;
        }
    }

    public static class Transaction {

        private String id;                 // transactionId de Wompi
        private String status;             // APPROVED, DECLINED, ERROR, VOIDED
        private BigDecimal amountInCents;  // Wompi maneja centavos
        private String reference;          // Referencia de compra
        private String paymentMethodType;  // CARD, PSE, etc
        private LocalDateTime createdAt;
        private LocalDateTime finalizedAt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public BigDecimal getAmountInCents() {
            return amountInCents;
        }

        public void setAmountInCents(BigDecimal amountInCents) {
            this.amountInCents = amountInCents;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getPaymentMethodType() {
            return paymentMethodType;
        }

        public void setPaymentMethodType(String paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getFinalizedAt() {
            return finalizedAt;
        }

        public void setFinalizedAt(LocalDateTime finalizedAt) {
            this.finalizedAt = finalizedAt;
        }
    }
}
