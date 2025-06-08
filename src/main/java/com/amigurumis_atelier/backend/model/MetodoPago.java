package com.amigurumis_atelier.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetodo;

    private String nombreMetodo;
    private String descripcion;
    private Boolean activo;

    // Getters y setters
    public Long getIdMetodo() { return idMetodo; }
    public void setIdMetodo(Long idMetodo) { this.idMetodo = idMetodo; }
    public String getNombreMetodo() { return nombreMetodo; }
    public void setNombreMetodo(String nombreMetodo) { this.nombreMetodo = nombreMetodo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}
