package com.amigurumis_atelier.backend.service;

import com.amigurumis_atelier.backend.model.Pedido;
import com.amigurumis_atelier.backend.repository.PedidoRepository;
import com.amigurumis_atelier.backend.serviceinterface.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Long id, Pedido pedido) {
        Pedido existe = pedidoRepository.findById(id).orElse(null);
        if (existe != null) {
            existe.setDireccion(pedido.getDireccion());
            existe.setFecha(pedido.getFecha());
            existe.setEstado(pedido.getEstado());
            existe.setTotalPrecioPedido(pedido.getTotalPrecioPedido());
            existe.setCantidadProducto(pedido.getCantidadProducto());
            existe.setUsuario(pedido.getUsuario());
            existe.setMetodoPago(pedido.getMetodoPago());
            return pedidoRepository.save(existe);
        } else {
            throw new RuntimeException("Pedido con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }
}
