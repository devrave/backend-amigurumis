package com.amigurumis_atelier.backend.service;

import com.amigurumis_atelier.backend.model.Carrito;
import com.amigurumis_atelier.backend.repository.CarritoRepository;
import com.amigurumis_atelier.backend.serviceinterface.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    @Override
    public Optional<Carrito> findById(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public Carrito save(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Carrito update(Long id, Carrito carrito) {
        Carrito carritoExiste = carritoRepository.findById(id).orElse(null);
        if (carritoExiste != null) {
            carritoExiste.setTotalPrecioCarrito(carrito.getTotalPrecioCarrito());
            carritoExiste.setCantidadProductos(carrito.getCantidadProductos());
            carritoExiste.setUsuario(carrito.getUsuario());
            return carritoRepository.save(carritoExiste);
        } else {
            throw new RuntimeException("Carrito con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Long id) {
        carritoRepository.deleteById(id);
    }
}
