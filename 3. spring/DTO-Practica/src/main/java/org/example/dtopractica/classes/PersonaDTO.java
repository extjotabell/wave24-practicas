package org.example.dtopractica.classes;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
public class PersonaDTO implements Serializable {

    private String nombre;
    private String apellido;
    private String deporte;

}
