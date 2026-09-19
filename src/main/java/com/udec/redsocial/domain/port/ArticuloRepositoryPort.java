package com.udec.redsocial.domain.port;

import com.udec.redsocial.domain.model.Articulo;
import java.util.List;
import java.util.Optional;

public interface ArticuloRepositoryPort {
    void guardar(Articulo articulo);
    Optional<Articulo> buscarPorId(String id);
    void actualizar(Articulo articulo);
    void eliminar(String id);
    List<Articulo> listarTodos();
}