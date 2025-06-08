package com.amigurumis_atelier.backend.serviceinterface;

import com.amigurumis_atelier.backend.model.DetallePedido;
import java.util.List;
import java.util.Optional;

public interface DetallePedidoService {
    List<DetallePedido> findAll();
    Optional<DetallePedido> findById(Long id);
    DetallePedido save(DetallePedido detallePedido);
    DetallePedido update(Long id, DetallePedido detallePedido);
    void deleteById(Long id);
}
