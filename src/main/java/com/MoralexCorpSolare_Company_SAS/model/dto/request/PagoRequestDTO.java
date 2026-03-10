package com.MoralexCorpSolare_Company_SAS.model.dto.request;

import com.MoralexCorpSolare_Company_SAS.model.enums.MetodoPago;

import java.math.BigDecimal;


public class PagoRequestDTO {

    private Long gafasId;

    private Integer cantidad;

    private BigDecimal monto;

    private MetodoPago metodoPago;

    private String correoCliente;

    private String referencia;

    public PagoRequestDTO() {
    }

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

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
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
