package com.MoralexCorpSolare_Company_SAS.mapper;

import com.MoralexCorpSolare_Company_SAS.dto.PagoRequestDTO;
import com.MoralexCorpSolare_Company_SAS.dto.PagoResponseDTO;
import com.MoralexCorpSolare_Company_SAS.entity.Pago;

public class PagoMapper {

    // Entity -> ResponseDTO
    public static PagoResponseDTO toResponseDTO(Pago pago) {

        if (pago == null) {
            return null;
        }

        PagoResponseDTO dto = new PagoResponseDTO();

        dto.setId(pago.getId());
        dto.setMonto(pago.getMonto());
        dto.setMetodoPago(pago.getMetodoPago());
        dto.setEstado(pago.getEstadoPago());
        dto.setReferenciaWompi(pago.getTransactionId());
        dto.setFechaPago(pago.getFechaCreacion());

        return dto;
    }

    // RequestDTO -> Entity
    public static Pago toEntity(PagoRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Pago pago = new Pago();

        pago.setMonto(dto.getMonto());
        pago.setMetodoPago(dto.getMetodoPago().name()); // enum -> String
        pago.setTransactionId(dto.getReferencia());
        pago.setEstadoPago("PENDIENTE");

        return pago;
    }

    // Update entity
    public static void updateEntity(PagoRequestDTO dto, Pago pago) {

        if (dto == null || pago == null) {
            return;
        }

        pago.setMonto(dto.getMonto());
        pago.setMetodoPago(dto.getMetodoPago().name());
        pago.setTransactionId(dto.getReferencia());
    }
}
