package com.amigurumis_atelier.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito;

    private Double totalPrecioCarrito;
    private Integer cantidadProductos;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Getters y setters
    public Long getIdCarrito() { return idCarrito; }
    public void setIdCarrito(Long idCarrito) { this.idCarrito = idCarrito; }
    public Double getTotalPrecioCarrito() { return totalPrecioCarrito; }
    public void setTotalPrecioCarrito(Double totalPrecioCarrito) { this.totalPrecioCarrito = totalPrecioCarrito; }
    public Integer getCantidadProductos() { return cantidadProductos; }
    public void setCantidadProductos(Integer cantidadProductos) { this.cantidadProductos = cantidadProductos; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
