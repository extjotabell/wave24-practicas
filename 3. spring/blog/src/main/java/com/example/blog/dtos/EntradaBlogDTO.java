package com.example.blog.dtos;

import java.time.LocalDate;

public record EntradaBlogDTO(
        Long id,
        String titulo,
        String nombreAutor,
        LocalDate fechaPublicacion
) {
}
