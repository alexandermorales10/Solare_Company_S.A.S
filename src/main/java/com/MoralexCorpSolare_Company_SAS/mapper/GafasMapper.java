package com.MoralexCorpSolare_Company_SAS.mapper;

import com.MoralexCorpSolare_Company_SAS.dto.GafasRequestDTO;
import com.MoralexCorpSolare_Company_SAS.dto.GafasResponseDTO;
import com.MoralexCorpSolare_Company_SAS.entity.Gafas;

public class GafasMapper {

    // Convertir RequestDTO -> Entity
    public static Gafas toEntity(GafasRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Gafas gafas = new Gafas();
        gafas.setMarca(dto.getMarca());
        gafas.setModelo(dto.getModelo());
        gafas.setPrecio(dto.getPrecio());
        gafas.setStock(dto.getStock());

        return gafas;
    }

    // Convertir Entity -> ResponseDTO
    public static GafasResponseDTO toResponseDTO(Gafas gafas) {

        if (gafas == null) {
            return null;
        }

        GafasResponseDTO dto = new GafasResponseDTO();
        dto.setId(gafas.getId());
        dto.setMarca(gafas.getMarca());
        dto.setModelo(gafas.getModelo());
        dto.setPrecio(gafas.getPrecio());
        dto.setStock(gafas.getStock());
        return dto;
    }

    // Actualizar entity existente (útil para PUT o PATCH)
    public static void updateEntity(GafasRequestDTO dto, Gafas gafas) {

        if (dto == null || gafas == null) {
            return;
        }

        gafas.setMarca(dto.getMarca());
        gafas.setModelo(dto.getModelo());
        gafas.setPrecio(dto.getPrecio());
        gafas.setStock(dto.getStock());
    }
}
