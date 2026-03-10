package com.MoralexCorpSolare_Company_SAS.service.impl;

import com.MoralexCorpSolare_Company_SAS.model.dto.request.AuthRequest;
import com.MoralexCorpSolare_Company_SAS.model.dto.response.AuthResponse;
import com.MoralexCorpSolare_Company_SAS.model.dto.request.RegisterRequest;
import com.MoralexCorpSolare_Company_SAS.model.dto.response.RegisterResponse;
import com.MoralexCorpSolare_Company_SAS.model.entity.Usuario;
import com.MoralexCorpSolare_Company_SAS.model.enums.RolUsuario;
import com.MoralexCorpSolare_Company_SAS.repository.UsuarioRepository;
import com.MoralexCorpSolare_Company_SAS.security.JwtService;
import com.MoralexCorpSolare_Company_SAS.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           JwtService jwtService,
                           UsuarioRepository usuarioRepository,
                           PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse login(AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getCorreo(),
                        request.getPassword()
                )
        );

        Usuario usuario = usuarioRepository.findByCorreo(request.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtService.generateToken(request.getCorreo());

        return new AuthResponse(token);
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if (usuarioRepository.existsByCorreo(request.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setCorreo(request.getCorreo());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setActivo(true);
        usuario.setRolUsuario(RolUsuario.CLIENTE);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        String token = jwtService.generateToken(usuarioGuardado.getCorreo());

        return new RegisterResponse(
                usuarioGuardado.getId(),
                usuarioGuardado.getNombre(),
                usuarioGuardado.getApellido(),
                usuarioGuardado.getCorreo(),
                token
        );
    }
}