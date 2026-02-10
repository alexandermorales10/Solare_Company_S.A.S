package com.MoralexCorpSolare_Company_SAS.dto;

public class UsuarioResponseDTO {

    private Long id;
    private String nombre;
    private String correo;
    private String rolUsuario;
    private Boolean activo;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nombre, String correo,
                              String rolUsuario, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rolUsuario = rolUsuario;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
