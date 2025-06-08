package com.amigurumis_atelier.backend.repository;

import com.amigurumis_atelier.backend.model.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito, Long> {
}
