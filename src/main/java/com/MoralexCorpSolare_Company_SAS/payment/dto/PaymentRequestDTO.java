package com.MoralexCorpSolare_Company_SAS.payment.dto;

import com.MoralexCorpSolare_Company_SAS.enums.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequestDTO {

    private Long gafasId;

    private Integer cantidad;

    private BigDecimal monto;

    private PaymentMethod metodoPago;

    private String emailCliente;

    private String referenciaCompra;
}
