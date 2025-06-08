package com.amigurumis_atelier.backend.service;

import com.amigurumis_atelier.backend.model.DetalleCarrito;
import com.amigurumis_atelier.backend.repository.DetalleCarritoRepository;
import com.amigurumis_atelier.backend.serviceinterface.DetalleCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCarritoServiceImpl implements DetalleCarritoService {
    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;

    @Override
    public List<DetalleCarrito> findAll() {
        return detalleCarritoRepository.findAll();
    }

    @Override
    public Optional<DetalleCarrito> findById(Long id) {
        return detalleCarritoRepository.findById(id);
    }

    @Override
    public DetalleCarrito save(DetalleCarrito detalleCarrito) {
        return detalleCarritoRepository.save(detalleCarrito);
    }

    @Override
    public DetalleCarrito update(Long id, DetalleCarrito detalleCarrito) {
        DetalleCarrito existe = detalleCarritoRepository.findById(id).orElse(null);
        if (existe != null) {
            existe.setPersonalizacion(detalleCarrito.getPersonalizacion());
            existe.setTamano(detalleCarrito.getTamano());
            existe.setEmpaqueEspecial(detalleCarrito.getEmpaqueEspecial());
            existe.setCantidad(detalleCarrito.getCantidad());
            existe.setPrecioUnitario(detalleCarrito.getPrecioUnitario());
            existe.setSubtotal(detalleCarrito.getSubtotal());
            existe.setCarrito(detalleCarrito.getCarrito());
            existe.setProducto(detalleCarrito.getProducto());
            return detalleCarritoRepository.save(existe);
        } else {
            throw new RuntimeException("DetalleCarrito con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Long id) {
        detalleCarritoRepository.deleteById(id);
    }
}
