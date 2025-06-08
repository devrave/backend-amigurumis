package com.amigurumis_atelier.backend.serviceinterface;

import com.amigurumis_atelier.backend.model.MetodoPago;
import java.util.List;
import java.util.Optional;

public interface MetodoPagoService {
    List<MetodoPago> findAll();
    Optional<MetodoPago> findById(Long id);
    MetodoPago save(MetodoPago metodoPago);
    MetodoPago update(Long id, MetodoPago metodoPago);
    void deleteById(Long id);
}
