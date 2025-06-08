package com.amigurumis_atelier.backend.service;

import com.amigurumis_atelier.backend.model.Producto;
import com.amigurumis_atelier.backend.repository.ProductoRepository;
import com.amigurumis_atelier.backend.serviceinterface.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Long id, Producto producto) {
        Producto productoExiste = productoRepository.findById(id).orElse(null);
        if (productoExiste != null) {
            productoExiste.setNombre(producto.getNombre());
            productoExiste.setTamano(producto.getTamano());
            productoExiste.setPrecio(producto.getPrecio());
            productoExiste.setStock(producto.getStock());
            productoExiste.setDisponibilidad(producto.getDisponibilidad());
            return productoRepository.save(productoExiste);
        } else {
            throw new RuntimeException("Producto con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
