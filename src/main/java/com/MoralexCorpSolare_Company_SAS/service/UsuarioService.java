package com.MoralexCorpSolare_Company_SAS.service;

import com.MoralexCorpSolare_Company_SAS.model.entity.Usuario;
import java.util.List;


public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    Usuario findById(Long id);
    void eliminar(Long id);

}
