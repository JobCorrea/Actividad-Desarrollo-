package com.udec.redsocial.application.usecase;

import com.udec.redsocial.domain.model.Articulo;
import com.udec.redsocial.domain.port.ArticuloRepositoryPort;
import java.util.List;

public class ListarArticulosUseCase {
    private final ArticuloRepositoryPort repository;

    public ListarArticulosUseCase(ArticuloRepositoryPort repository) {
        this.repository = repository;
    }

    public List<Articulo> ejecutar() {
        return repository.listarTodos();
    }
}