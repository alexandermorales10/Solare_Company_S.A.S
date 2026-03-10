package com.MoralexCorpSolare_Company_SAS.model.dto.request;

public class AuthRequest {
    private String correo;
    private String password;

    public AuthRequest(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
