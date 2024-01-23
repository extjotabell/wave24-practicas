package com.demospring.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record AlumnoDTO(

        @Size(min = 6, max = 8, message = "El dni no puede contener menos de 6 caracteres ni mas de 8")
        String dni,

        @Size(min = 5, max = 100, message = "El nombre no puede contener menos de 5 caracteres ni mas de 100")
        String name,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate birthDate,

        @Min(value = 0, message = "El minimo de edad debe ser de 0")
        @Max(value = 100, message = "El maximo de edad debe ser de 100")
        Integer age,

        @Size(min = 1, message = "El alumno debe estar registrado en al menos una materia")
        List<@Valid MateriaDTO> materiasList
        ){
}
