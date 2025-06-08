package com.amigurumis_atelier.backend.serviceinterface;

import com.amigurumis_atelier.backend.model.Rol;
import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> findAll();
    Optional<Rol> findById(Long id);
    Rol save(Rol rol);
    Rol update(Long id, Rol rol);
    void deleteById(Long id);
}
