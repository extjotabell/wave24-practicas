package com.deportistas.deportistas.classes;

public class DeportistaDTO {
    private final String deporte;
    private final String persona;

    public DeportistaDTO(Deporte deporte, Persona persona) {
        this.deporte = deporte.getNombre();
        this.persona = persona.fullName();
    }

    public String getDeporte() {
        return deporte;
    }

    public String getPersona() {
        return persona;
    }

    @Override
    public String toString() {
        return "{" +
                "deporte: '" + deporte + "'" +
                ", persona: '" + persona + "'"+
                '}';
    }
}
