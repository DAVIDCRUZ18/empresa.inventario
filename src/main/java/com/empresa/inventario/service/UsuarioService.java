package com.empresa.inventario.service;

import com.empresa.inventario.model.Usuario;
import com.empresa.inventario.model.dto.LoginRequest;
import com.empresa.inventario.model.dto.RegistroRequest;
import com.empresa.inventario.model.dto.AuthResponse;
import com.empresa.inventario.repository.UsuarioRepository;
import com.empresa.inventario.security.JwtService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String registrar(RegistroRequest request) {

        if (usuarioRepository.findByUsuario(request.getUsuario()).isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setUsuario(request.getUsuario());
        usuario.setTelefono(request.getTelefono());
        usuario.setRol(request.getRol());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));

        usuarioRepository.save(usuario);

        return "Usuario registrado exitosamente";
    }

    public AuthResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository.findByUsuario(request.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(usuario.getUsuario());

        return new AuthResponse(token);
    }
}
