package com.udec.redsocial.infrastructure.primaryadapter.cli;

import com.udec.redsocial.application.usecase.*;
import com.udec.redsocial.domain.model.Articulo;
import com.udec.redsocial.domain.port.ArticuloRepositoryPort;
import com.udec.redsocial.infrastructure.adapter.memory.InMemoryArticuloRepository;
import java.util.List;
import java.util.Scanner;

public class ArticuloCliAdapter {
    public static void main(String[] args) {
        // Inyección de Dependencias
        ArticuloRepositoryPort repository = new InMemoryArticuloRepository();
        CrearArticuloUseCase crearUseCase = new CrearArticuloUseCase(repository);
        ListarArticulosUseCase listarUseCase = new ListarArticulosUseCase(repository);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MÓDULO DE ARTÍCULOS (RED SOCIAL) ---");
            System.out.println("1. Crear nuevo artículo");
            System.out.println("2. Listar todos los artículos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Título del artículo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Resumen: ");
                    String resumen = scanner.nextLine();
                    System.out.print("Contenido: ");
                    String contenido = scanner.nextLine();
                    System.out.print("ID del Autor: ");
                    String autorId = scanner.nextLine();
                    System.out.print("ID del Grupo: ");
                    String grupoId = scanner.nextLine();

                    Articulo nuevo = crearUseCase.ejecutar(titulo, resumen, contenido, autorId, grupoId);
                    System.out.println("\n[ÉXITO] Artículo creado con ID: " + nuevo.getId() + " | Estado: " + nuevo.getEstadoEditorial());
                }
                case 2 -> {
                    List<Articulo> articulos = listarUseCase.ejecutar();
                    System.out.println("\n--- LISTA DE ARTÍCULOS ---");
                    if (articulos.isEmpty()) {
                        System.out.println("No hay artículos registrados.");
                    } else {
                        articulos.forEach(art -> 
                            System.out.println("[" + art.getId() + "] " + art.getTitulo() + 
                                               " - Estado: " + art.getEstadoEditorial() + 
                                               " (Autor: " + art.getAutorId() + ")")
                        );
                    }
                }
                case 3 -> {
                    System.out.println("Saliendo de la aplicación...");
                    salir = true;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}