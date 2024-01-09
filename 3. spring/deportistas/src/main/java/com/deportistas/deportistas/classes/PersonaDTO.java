package com.deportistas.deportistas.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@Getter
public class PersonaDTO implements Serializable {

    private String nombre;
    private String apellidos;
    private String deporte;


}
