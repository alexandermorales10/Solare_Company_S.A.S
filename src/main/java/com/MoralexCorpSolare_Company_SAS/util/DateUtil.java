package com.MoralexCorpSolare_Company_SAS.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.ZoneId;

public class DateUtil {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Obtener fecha actual
    public static LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    // Obtener fecha y hora actual
    public static LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    // Formatear LocalDate a String
    public static String formatearFecha(LocalDate fecha) {
        if (fecha == null) return null;
        return fecha.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    // Formatear LocalDateTime a String
    public static String formatearFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null) return null;
        return fechaHora.format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT));
    }

    // Convertir String a LocalDate
    public static LocalDate convertirAFecha(String fecha) {
        if (fecha == null || fecha.isEmpty()) return null;
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    // Convertir Date a LocalDate
    public static LocalDate convertirDateALocalDate(Date date) {
        if (date == null) return null;
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    // Convertir Date a LocalDateTime
    public static LocalDateTime convertirDateALocalDateTime(Date date) {
        if (date == null) return null;
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
