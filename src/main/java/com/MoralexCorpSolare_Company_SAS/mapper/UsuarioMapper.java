package com.MoralexCorpSolare_Company_SAS.mapper;

import com.MoralexCorpSolare_Company_SAS.model.dto.request.UsuarioRequestDTO;
import com.MoralexCorpSolare_Company_SAS.model.dto.response.UsuarioResponseDTO;
import com.MoralexCorpSolare_Company_SAS.model.entity.Usuario;
import com.MoralexCorpSolare_Company_SAS.model.enums.RolUsuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

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
        usuario.setCorreo(dto.getCorreo());
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
        usuario.setCorreo(dto.getCorreo());

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            usuario.setPassword(dto.getPassword());
        }

        usuario.setRolUsuario(RolUsuario.valueOf(dto.getRol().toUpperCase()));
    }

    public static UserDetails userToUserDetails(Usuario usuario){
        String username = usuario.getCorreo();
        String password = usuario.getPassword();
        Collection<? extends GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ADMIN"));

        User user = new User(
                username,
                password,
                true,
                true,
                true,
                true,
                authorities
        );

        return user;
    }
}
