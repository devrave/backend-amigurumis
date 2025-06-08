package com.amigurumis_atelier.backend.controller;

import com.amigurumis_atelier.backend.model.Rol;
import com.amigurumis_atelier.backend.serviceinterface.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> getAll() {
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getById(@PathVariable Long id) {
        Optional<Rol> rol = rolService.findById(id);
        return rol.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rol create(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<String> actualizarRol(@PathVariable Long id, @RequestBody Rol rol) {
        try {
            rolService.update(id, rol);
            return ResponseEntity.ok("Rol actualizado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
