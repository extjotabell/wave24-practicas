package com.demospring.demo.dto;

import java.time.LocalDate;
import java.util.List;

public record AlumnoDTO(
        String dni,
        String name,
        LocalDate birthDate,
        Integer age,
        List<MateriaDTO> materiasList
        ){
}
