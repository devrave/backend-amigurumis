package com.amigurumis_atelier.backend.controller;

import com.amigurumis_atelier.backend.model.DetallePedido;
import com.amigurumis_atelier.backend.serviceinterface.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detallepedido")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedido> getAll() {
        return detallePedidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getById(@PathVariable Long id) {
        Optional<DetallePedido> detalle = detallePedidoService.findById(id);
        return detalle.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetallePedido create(@RequestBody DetallePedido detallePedido) {
        return detallePedidoService.save(detallePedido);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<String> actualizarDetallePedido(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
        try {
            detallePedidoService.update(id, detallePedido);
            return ResponseEntity.ok("DetallePedido actualizado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        detallePedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
