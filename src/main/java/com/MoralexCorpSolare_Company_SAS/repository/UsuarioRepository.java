package com.MoralexCorpSolare_Company_SAS.repository;

import com.MoralexCorpSolare_Company_SAS.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por correo
    Optional<Usuario> findByCorreo(String correo);

    // Verificar si existe un correo
    boolean existsByCorreo(String correo);

}