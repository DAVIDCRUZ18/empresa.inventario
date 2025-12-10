package com.empresa.inventario.controller;

import com.empresa.inventario.model.dto.LoginRequest;
import com.empresa.inventario.model.dto.RegistroRequest;
import com.empresa.inventario.model.dto.AuthResponse;
import com.empresa.inventario.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registro")
    public String registrar(@RequestBody RegistroRequest request) {
        return usuarioService.registrar(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return usuarioService.login(request);
    }
    @GetMapping("/ping")
    public String ping() {
        return "API funcionando";
    }

}