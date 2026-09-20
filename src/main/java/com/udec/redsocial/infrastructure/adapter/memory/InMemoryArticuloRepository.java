package com.udec.redsocial.infrastructure.adapter.memory;

import com.udec.redsocial.domain.model.Articulo;
import com.udec.redsocial.domain.port.ArticuloRepositoryPort;
import java.util.*;

public class InMemoryArticuloRepository implements ArticuloRepositoryPort {
    private final Map<String, Articulo> database = new HashMap<>();

    @Override
    public void guardar(Articulo articulo) {
        database.put(articulo.getId(), articulo);
    }

    @Override
    public Optional<Articulo> buscarPorId(String id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public void actualizar(Articulo articulo) {
        if (database.containsKey(articulo.getId())) {
            database.put(articulo.getId(), articulo);
        }
    }

    @Override
    public void eliminar(String id) {
        database.remove(id);
    }

    @Override
    public List<Articulo> listarTodos() {
        return new ArrayList<>(database.values());
    }
}