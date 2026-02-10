package com.MoralexCorpSolare_Company_SAS.dto;

import com.MoralexCorpSolare_Company_SAS.enums.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponseDTO {

    private Long id;

    private Long gafasId;

    private Integer cantidad;

    private BigDecimal monto;

    private String estado;

    private PaymentMethod metodoPago;

    private String referencia;

    private String referenciaWompi;

    private LocalDateTime fechaPago;

    public void setMetodoPago(String metodoPago) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PaymentMethod getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(PaymentMethod metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReferenciaWompi() {
        return referenciaWompi;
    }

    public void setReferenciaWompi(String referenciaWompi) {
        this.referenciaWompi = referenciaWompi;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }
}
