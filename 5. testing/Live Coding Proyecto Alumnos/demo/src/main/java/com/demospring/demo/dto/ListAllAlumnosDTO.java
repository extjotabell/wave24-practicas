package com.demospring.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public record ListAllAlumnosDTO(
    List<AlumnoDTO> alumnoList
){
}
