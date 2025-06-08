package com.amigurumis_atelier.backend.service;

import com.amigurumis_atelier.backend.model.DetallePedido;
import com.amigurumis_atelier.backend.repository.DetallePedidoRepository;
import com.amigurumis_atelier.backend.serviceinterface.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedido> findAll() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public Optional<DetallePedido> findById(Long id) {
        return detallePedidoRepository.findById(id);
    }

    @Override
    public DetallePedido save(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public DetallePedido update(Long id, DetallePedido detallePedido) {
        DetallePedido existe = detallePedidoRepository.findById(id).orElse(null);
        if (existe != null) {
            existe.setCantidad(detallePedido.getCantidad());
            existe.setPrecioUnitario(detallePedido.getPrecioUnitario());
            existe.setSubtotal(detallePedido.getSubtotal());
            existe.setProducto(detallePedido.getProducto());
            existe.setPedido(detallePedido.getPedido());
            return detallePedidoRepository.save(existe);
        } else {
            throw new RuntimeException("DetallePedido con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Long id) {
        detallePedidoRepository.deleteById(id);
    }
}
