package com.amigurumis_atelier.backend.service;

import com.amigurumis_atelier.backend.model.MetodoPago;
import com.amigurumis_atelier.backend.repository.MetodoPagoRepository;
import com.amigurumis_atelier.backend.serviceinterface.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll();
    }

    @Override
    public Optional<MetodoPago> findById(Long id) {
        return metodoPagoRepository.findById(id);
    }

    @Override
    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    public MetodoPago update(Long id, MetodoPago metodoPago) {
        MetodoPago existe = metodoPagoRepository.findById(id).orElse(null);
        if (existe != null) {
            existe.setNombreMetodo(metodoPago.getNombreMetodo());
            existe.setDescripcion(metodoPago.getDescripcion());
            existe.setActivo(metodoPago.getActivo());
            return metodoPagoRepository.save(existe);
        } else {
            throw new RuntimeException("MetodoPago con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Long id) {
        metodoPagoRepository.deleteById(id);
    }
}
