package com.amigurumis_atelier.backend.controller;

import com.amigurumis_atelier.backend.model.Carrito;
import com.amigurumis_atelier.backend.serviceinterface.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> getAll() {
        return carritoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getById(@PathVariable Long id) {
        Optional<Carrito> carrito = carritoService.findById(id);
        return carrito.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carrito create(@RequestBody Carrito carrito) {
        return carritoService.save(carrito);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<String> actualizarCarrito(@PathVariable Long id, @RequestBody Carrito carrito) {
        try {
            carritoService.update(id, carrito);
            return ResponseEntity.ok("Carrito actualizado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carritoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
