package com.MoralexCorpSolare_Company_SAS.util;

import java.text.Normalizer;

public class StringUtil {

    // Validar si un String es null o vacío
    public static boolean esVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    // Convertir a mayúsculas de forma segura
    public static String aMayusculas(String texto) {
        if (esVacio(texto)) {
            return texto;
        }
        return texto.toUpperCase();
    }

    // Convertir a minúsculas de forma segura
    public static String aMinusculas(String texto) {
        if (esVacio(texto)) {
            return texto;
        }
        return texto.toLowerCase();
    }

    // Quitar espacios al inicio y final
    public static String limpiarEspacios(String texto) {
        if (texto == null) {
            return null;
        }
        return texto.trim();
    }

    // Capitalizar primera letra
    public static String capitalizar(String texto) {
        if (esVacio(texto)) {
            return texto;
        }

        texto = texto.trim();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    // Eliminar tildes y caracteres especiales
    public static String quitarTildes(String texto) {
        if (esVacio(texto)) {
            return texto;
        }

        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return normalizado.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    // Validar si contiene solo números
    public static boolean esNumerico(String texto) {
        if (esVacio(texto)) {
            return false;
        }
        return texto.matches("\\d+");
    }

    // Limitar longitud de un String
    public static String limitarLongitud(String texto, int maxLongitud) {
        if (texto == null) {
            return null;
        }

        if (texto.length() <= maxLongitud) {
            return texto;
        }

        return texto.substring(0, maxLongitud);
    }
}
