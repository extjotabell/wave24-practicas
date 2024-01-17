package org.example.ejercicio.dto;

import java.time.LocalDate;

public record EntradaBlogDTO(
        String titulo,
        String nombreAutor,
        LocalDate fechaPublicacion
) {
}
