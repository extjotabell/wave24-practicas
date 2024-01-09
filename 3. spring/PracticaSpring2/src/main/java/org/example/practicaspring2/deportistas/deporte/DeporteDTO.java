package org.example.practicaspring2.deportistas.deporte;

public class DeporteDTO {

    private final String nombre;
    private final Integer nivel;

    public DeporteDTO(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public static DeporteDTO create(Deporte deporte) {
        return new DeporteDTO(deporte.getNombre(), deporte.getNivel());
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

}
