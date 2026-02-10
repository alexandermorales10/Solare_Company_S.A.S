package com.MoralexCorpSolare_Company_SAS.mapper;

import com.MoralexCorpSolare_Company_SAS.dto.UsuarioRequestDTO;
import com.MoralexCorpSolare_Company_SAS.dto.UsuarioResponseDTO;
import com.MoralexCorpSolare_Company_SAS.entity.Usuario;
import com.MoralexCorpSolare_Company_SAS.enums.RolUsuario;

public class UsuarioMapper {

    public static UsuarioResponseDTO toResponseDTO(Usuario usuario) {

        if (usuario == null) {
            return null;
        }

        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setCorreo(usuario.getCorreo());
        dto.setRolUsuario(usuario.getRolUsuario().name());
        dto.setActivo(usuario.getActivo());

        return dto;
    }

    // Convertir RequestDTO -> Entity
    public static Usuario toEntity(UsuarioRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getEmail());
        usuario.setPassword(dto.getPassword());

        // Convertir String -> Enum
        usuario.setRolUsuario(RolUsuario.valueOf(dto.getRol().toUpperCase()));

        // Por defecto usuario activo
        usuario.setActivo(true);

        return usuario;
    }

    // Actualizar entity existente
    public static void updateEntity(UsuarioRequestDTO dto, Usuario usuario) {

        if (dto == null || usuario == null) {
            return;
        }

        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getEmail());

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            usuario.setPassword(dto.getPassword());
        }

        usuario.setRolUsuario(RolUsuario.valueOf(dto.getRol().toUpperCase()));
    }
}
