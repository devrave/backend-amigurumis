package com.amigurumis_atelier.backend.service;

import com.amigurumis_atelier.backend.model.Rol;
import com.amigurumis_atelier.backend.repository.RolRepository;
import com.amigurumis_atelier.backend.serviceinterface.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Long id, Rol rol) {
        Rol rolExiste = rolRepository.findById(id).orElse(null);
        if (rolExiste != null) {
            rolExiste.setNombreRol(rol.getNombreRol());
            return rolRepository.save(rolExiste);
        } else {
            throw new RuntimeException("Rol con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }
}
