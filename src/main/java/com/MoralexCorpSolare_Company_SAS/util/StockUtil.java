package com.MoralexCorpSolare_Company_SAS.util;

public class StockUtil {

    // Validar si hay stock suficiente
    public static boolean hayStockDisponible(Integer stockActual, Integer cantidadSolicitada) {
        if (stockActual == null || cantidadSolicitada == null) {
            return false;
        }
        return stockActual >= cantidadSolicitada;
    }

    // Reducir stock después de una venta
    public static Integer reducirStock(Integer stockActual, Integer cantidadVendida) {
        if (stockActual == null || cantidadVendida == null) {
            throw new IllegalArgumentException("El stock o la cantidad vendida no pueden ser null");
        }

        if (cantidadVendida > stockActual) {
            throw new IllegalArgumentException("No hay suficiente stock disponible");
        }

        return stockActual - cantidadVendida;
    }

    // Aumentar stock (por reposición o devolución)
    public static Integer aumentarStock(Integer stockActual, Integer cantidadAgregar) {
        if (stockActual == null) {
            stockActual = 0;
        }

        if (cantidadAgregar == null || cantidadAgregar < 0) {
            throw new IllegalArgumentException("Cantidad inválida para agregar al stock");
        }

        return stockActual + cantidadAgregar;
    }

    // Validar si el stock está agotado
    public static boolean stockAgotado(Integer stockActual) {
        return stockActual == null || stockActual <= 0;
    }

    // Validar si el stock es bajo según un mínimo permitido
    public static boolean stockBajo(Integer stockActual, Integer stockMinimo) {
        if (stockActual == null || stockMinimo == null) {
            return false;
        }
        return stockActual <= stockMinimo;
    }
}
