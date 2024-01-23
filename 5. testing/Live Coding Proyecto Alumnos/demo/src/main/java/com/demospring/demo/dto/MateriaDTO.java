package com.demospring.demo.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record MateriaDTO(
    String id,

    @Size(min = 5, max = 20, message = "El nombre de materia debe estar entre 5 y 20 caracteres")
    String name,

    @PositiveOrZero(message = "El promedio debe ser positivo.")
    Double promedio
    ){
}
