package com.MoralexCorpSolare_Company_SAS.security;

import com.MoralexCorpSolare_Company_SAS.mapper.UsuarioMapper;
import com.MoralexCorpSolare_Company_SAS.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioRepository repository;

    public UserDetailsServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByCorreo(username).map(UsuarioMapper::userToUserDetails).orElseThrow(() -> new UsernameNotFoundException("Error al intentar login"));
    }
}


