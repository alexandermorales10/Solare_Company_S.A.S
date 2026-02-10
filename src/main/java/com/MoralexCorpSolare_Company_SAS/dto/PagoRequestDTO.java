package com.MoralexCorpSolare_Company_SAS.dto;

import com.MoralexCorpSolare_Company_SAS.enums.PaymentMethod;

import java.math.BigDecimal;


public class PagoRequestDTO {

    private Long gafasId;

    private Integer cantidad;

    private BigDecimal monto;

    private PaymentMethod metodoPago;

    private String emailCliente;

    private String referencia;

    public Long getGafasId() {
        return gafasId;
    }

    public void setGafasId(Long gafasId) {
        this.gafasId = gafasId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public PaymentMethod getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(PaymentMethod metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
