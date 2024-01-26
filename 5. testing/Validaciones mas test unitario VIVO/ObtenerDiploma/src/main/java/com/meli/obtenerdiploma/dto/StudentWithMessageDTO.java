package com.meli.obtenerdiploma.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Set;

public record StudentWithMessageDTO (
        Long id,

        @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
        @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
        @Size(max = 50, message = "La longitud del nombre del estudiante no puede superar los 50 caracteres.")
        String studentName,

        @NotEmpty(message = "La lista de materias no puede estar vacía.")
        Set<@Valid SubjectDTO> subjects,

        String message,
        Double averageScore


) {
}
