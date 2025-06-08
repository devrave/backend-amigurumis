package com.amigurumis_atelier.backend.serviceinterface;

import com.amigurumis_atelier.backend.model.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    Pedido save(Pedido pedido);
    Pedido update(Long id, Pedido pedido);
    void deleteById(Long id);
}
