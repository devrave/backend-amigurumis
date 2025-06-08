package com.amigurumis_atelier.backend.serviceinterface;

import com.amigurumis_atelier.backend.model.DetalleCarrito;
import java.util.List;
import java.util.Optional;

public interface DetalleCarritoService {
    List<DetalleCarrito> findAll();
    Optional<DetalleCarrito> findById(Long id);
    DetalleCarrito save(DetalleCarrito detalleCarrito);
    DetalleCarrito update(Long id, DetalleCarrito detalleCarrito);
    void deleteById(Long id);
}
