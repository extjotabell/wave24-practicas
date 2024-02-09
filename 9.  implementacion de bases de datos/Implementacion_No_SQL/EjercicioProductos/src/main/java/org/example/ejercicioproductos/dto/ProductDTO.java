package org.example.ejercicioproductos.dto;

public record ProductDTO(
        Long id,
        String nombre,
        String tipo,
        Double precioVenta,
        Double precioCosto,
        Integer cantidad
) {
}
