package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotNull(message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayuscula")
    @Size(max = 50, message = "El nombre del alumno no puede tener mas de 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @NotNull(message = "La lista de materias no puede estar vacia")
    List<@Valid SubjectDTO> subjects;
}
