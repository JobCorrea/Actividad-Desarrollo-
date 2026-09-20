package com.udec.redsocial.application.usecase;

import com.udec.redsocial.domain.model.Articulo;
import com.udec.redsocial.domain.port.ArticuloRepositoryPort;

public class CrearArticuloUseCase {
    private final ArticuloRepositoryPort repository;

    public CrearArticuloUseCase(ArticuloRepositoryPort repository) {
        this.repository = repository;
    }

    public Articulo ejecutar(String titulo, String resumen, String contenido, String autorId, String grupoId) {
        Articulo articulo = new Articulo(titulo, resumen, contenido, autorId, grupoId);
        repository.guardar(articulo);
        return articulo;
    }
}