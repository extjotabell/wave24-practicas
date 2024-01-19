package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayuscula")
    @Size(max = 30, message = "El nombre de la materia no puede tener mas de 30 caracteres")
    String name;
    @NotNull(message = "El puntaje de la materia no puede estar vacio")
    @DecimalMin(value = "0.0", message = "La minima nota es 0.0")
    @DecimalMax(value = "10.0", message = "La maxima nota es 10.0")
    Double score;
}
