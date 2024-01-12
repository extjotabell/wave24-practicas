package com.spring.Deportistas.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class PersonaDTO implements Serializable {

    private String nombre;
    private String apellido;
    private String deporte;
}
