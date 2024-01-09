package org.example.practicaspring2.deportistas.persona;

import org.example.practicaspring2.deportistas.deporte.DeporteAcotadoDTO;

public class PersonaDTO {

    private final String nombre;
    private final String apellido;
    private final DeporteAcotadoDTO deporteAcotadoDTO;

    public PersonaDTO(String nombre, String apellido, DeporteAcotadoDTO deporteAcotadoDTO) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporteAcotadoDTO = deporteAcotadoDTO;
    }

    public static PersonaDTO create(Persona persona) {
        return new PersonaDTO(persona.getNombre(), persona.getApellido(), new DeporteAcotadoDTO(persona.getDeporte().getNombre()));
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public DeporteAcotadoDTO getDeporteAcotadoDTO() {
        return deporteAcotadoDTO;
    }
}

