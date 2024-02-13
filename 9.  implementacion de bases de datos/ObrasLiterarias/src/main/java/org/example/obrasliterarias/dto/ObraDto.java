package org.example.obrasliterarias.dto;

public record ObraDto(
        Long id,
        String nombre,
        String autor,
        Integer cantidadPaginas,
        String editorial,
        Integer anioPublicacion
) {
}
