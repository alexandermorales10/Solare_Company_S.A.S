package com.MoralexCorpSolare_Company_SAS.payment.dto;

import com.MoralexCorpSolare_Company_SAS.enums.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentResponseDTO {

    private Long paymentId;

    private Long gafasId;

    private Integer cantidad;

    private BigDecimal monto;

    private PaymentMethod metodoPago;

    private String estadoPago;

    private String referenciaCompra;

    private String transactionIdWompi;

    private LocalDateTime fechaPago;

}
