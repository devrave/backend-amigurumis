package com.amigurumis_atelier.backend.service;

import com.amigurumis_atelier.backend.model.Usuario;
import com.amigurumis_atelier.backend.repository.UsuarioRepository;
import com.amigurumis_atelier.backend.serviceinterface.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioExiste = usuarioRepository.findById(id).orElse(null);
        if (usuarioExiste != null) {
            usuarioExiste.setNombre(usuario.getNombre());
            usuarioExiste.setCorreo(usuario.getCorreo());
            usuarioExiste.setTelefono(usuario.getTelefono());
            usuarioExiste.setContrasena(usuario.getContrasena());
            usuarioExiste.setRol(usuario.getRol());
            return usuarioRepository.save(usuarioExiste);
        } else {
            throw new RuntimeException("Usuario con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
