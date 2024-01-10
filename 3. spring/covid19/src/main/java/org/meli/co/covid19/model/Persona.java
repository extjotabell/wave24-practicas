package org.meli.co.covid19.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Persona {

    private Integer id;

    private String nombre;

    private String apellido;

    private Integer edad;

}
