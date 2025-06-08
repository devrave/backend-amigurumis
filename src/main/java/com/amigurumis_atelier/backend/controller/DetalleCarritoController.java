package com.amigurumis_atelier.backend.controller;

import com.amigurumis_atelier.backend.model.DetalleCarrito;
import com.amigurumis_atelier.backend.serviceinterface.DetalleCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detallecarrito")
public class DetalleCarritoController {
    @Autowired
    private DetalleCarritoService detalleCarritoService;

    @GetMapping
    public List<DetalleCarrito> getAll() {
        return detalleCarritoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCarrito> getById(@PathVariable Long id) {
        Optional<DetalleCarrito> detalle = detalleCarritoService.findById(id);
        return detalle.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetalleCarrito create(@RequestBody DetalleCarrito detalleCarrito) {
        return detalleCarritoService.save(detalleCarrito);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<String> actualizarDetalleCarrito(@PathVariable Long id, @RequestBody DetalleCarrito detalleCarrito) {
        try {
            detalleCarritoService.update(id, detalleCarrito);
            return ResponseEntity.ok("DetalleCarrito actualizado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        detalleCarritoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
