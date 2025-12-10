package com.empresa.inventario.model.dto;

import lombok.Data;

@Data
public class RegistroRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String usuario;
    private String telefono;
    private String rol;
    private String password;
}
