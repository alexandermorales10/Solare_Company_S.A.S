package com.MoralexCorpSolare_Company_SAS.dto;

import java.math.BigDecimal;

public class GafasResponseDTO {

    private Long id;
    private String marca;
    private String modelo;
    private BigDecimal precio;
    private Integer stock;
    private Boolean active;

    public GafasResponseDTO() {
    }

    public GafasResponseDTO(Long id, String marca, String modelo,
                            BigDecimal precio, Integer stock, Boolean active) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
