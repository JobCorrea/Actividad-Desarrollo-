package com.udec.redsocial.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Articulo {
    private String id;
    private String titulo;
    private String resumen;
    private String contenido;
    private String autorId;
    private String grupoId;
    private EstadoEditorial estadoEditorial;
    private LocalDateTime fechaCreacion;

    public Articulo(String titulo, String resumen, String contenido, String autorId, String grupoId) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.resumen = resumen;
        this.contenido = contenido;
        this.autorId = autorId;
        this.grupoId = grupoId;
        this.estadoEditorial = EstadoEditorial.ENVIADO; // Estado inicial por defecto
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getResumen() { return resumen; }
    public void setResumen(String resumen) { this.resumen = resumen; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public String getAutorId() { return autorId; }
    public String getGrupoId() { return grupoId; }
    public EstadoEditorial getEstadoEditorial() { return estadoEditorial; }
    public void setEstadoEditorial(EstadoEditorial estadoEditorial) { this.estadoEditorial = estadoEditorial; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}