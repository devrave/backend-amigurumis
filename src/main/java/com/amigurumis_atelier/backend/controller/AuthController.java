package com.amigurumis_atelier.backend.controller;

import com.amigurumis_atelier.backend.dto.LoginRequestDTO;
import com.amigurumis_atelier.backend.dto.RegisterRequestDTO;
import com.amigurumis_atelier.backend.model.Rol;
import com.amigurumis_atelier.backend.model.Usuario;
import com.amigurumis_atelier.backend.repository.RolRepository;
import com.amigurumis_atelier.backend.repository.UsuarioRepository;
import com.amigurumis_atelier.backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(loginRequest.getCorreo());
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(401).body(java.util.Collections.singletonMap("error", "Usuario no encontrado"));
        }
        Usuario usuario = usuarioOpt.get();
        if (!usuario.getContrasena().equals(loginRequest.getContrasena())) {
            return ResponseEntity.status(401).body(java.util.Collections.singletonMap("error", "Contraseña incorrecta"));
        }
        String token = JwtUtil.generateToken(
                usuario.getCorreo(),
                usuario.getIdUsuario(),
                usuario.getRol() != null ? usuario.getRol().getNombreRol() : "USER"
        );
        return ResponseEntity.ok(java.util.Collections.singletonMap("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequest) {
        if (usuarioRepository.findByCorreo(registerRequest.getCorreo()).isPresent()) {
            return ResponseEntity.status(409).body("El correo ya está registrado");
        }
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(registerRequest.getNombre());
        nuevoUsuario.setCorreo(registerRequest.getCorreo());
        nuevoUsuario.setTelefono(registerRequest.getTelefono());
        nuevoUsuario.setContrasena(registerRequest.getContrasena());
        // Asignar siempre el rol ADMIN (id=1)
        Rol rol = rolRepository.findById(1L).orElse(null);
        if (rol == null) {
            return ResponseEntity.status(400).body("Rol ADMIN no existe en la base de datos");
        }
        nuevoUsuario.setRol(rol);
        usuarioRepository.save(nuevoUsuario);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}
