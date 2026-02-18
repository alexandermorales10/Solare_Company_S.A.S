package com.MoralexCorpSolare_Company_SAS.dto;

import com.MoralexCorpSolare_Company_SAS.enums.PaymentMethod;

import java.math.BigDecimal;


public class PagoRequestDTO {

    private Long gafasId;

    private Integer cantidad;

    private BigDecimal monto;

    private PaymentMethod metodoPago;

    private String correoCliente;

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

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
