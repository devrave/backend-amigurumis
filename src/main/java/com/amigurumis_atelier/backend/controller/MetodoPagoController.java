package com.amigurumis_atelier.backend.controller;

import com.amigurumis_atelier.backend.model.MetodoPago;
import com.amigurumis_atelier.backend.serviceinterface.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metodospago")
public class MetodoPagoController {
    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public List<MetodoPago> getAll() {
        return metodoPagoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getById(@PathVariable Long id) {
        Optional<MetodoPago> metodo = metodoPagoService.findById(id);
        return metodo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MetodoPago create(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.save(metodoPago);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<String> actualizarMetodoPago(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        try {
            metodoPagoService.update(id, metodoPago);
            return ResponseEntity.ok("MetodoPago actualizado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        metodoPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
