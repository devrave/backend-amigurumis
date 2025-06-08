package com.amigurumis_atelier.backend.serviceinterface;

import com.amigurumis_atelier.backend.model.Carrito;
import java.util.List;
import java.util.Optional;

public interface CarritoService {
    List<Carrito> findAll();
    Optional<Carrito> findById(Long id);
    Carrito save(Carrito carrito);
    Carrito update(Long id, Carrito carrito);
    void deleteById(Long id);
}
