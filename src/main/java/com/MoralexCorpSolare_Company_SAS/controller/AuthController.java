package com.MoralexCorpSolare_Company_SAS.controller;

import com.MoralexCorpSolare_Company_SAS.model.dto.request.AuthRequest;
import com.MoralexCorpSolare_Company_SAS.model.dto.response.AuthResponse;
import com.MoralexCorpSolare_Company_SAS.model.dto.request.RegisterRequest;
import com.MoralexCorpSolare_Company_SAS.model.dto.response.RegisterResponse;
import com.MoralexCorpSolare_Company_SAS.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}