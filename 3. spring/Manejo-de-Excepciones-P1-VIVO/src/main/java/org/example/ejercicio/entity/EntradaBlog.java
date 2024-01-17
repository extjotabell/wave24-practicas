package org.example.ejercicio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {

    private Long id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
