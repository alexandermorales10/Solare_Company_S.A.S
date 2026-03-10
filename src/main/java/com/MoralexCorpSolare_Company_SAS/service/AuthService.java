package com.MoralexCorpSolare_Company_SAS.service;

import com.MoralexCorpSolare_Company_SAS.model.dto.request.AuthRequest;
import com.MoralexCorpSolare_Company_SAS.model.dto.response.AuthResponse;
import com.MoralexCorpSolare_Company_SAS.model.dto.request.RegisterRequest;
import com.MoralexCorpSolare_Company_SAS.model.dto.response.RegisterResponse;

public interface AuthService {

    AuthResponse login(AuthRequest request);

    RegisterResponse register(RegisterRequest request);

}