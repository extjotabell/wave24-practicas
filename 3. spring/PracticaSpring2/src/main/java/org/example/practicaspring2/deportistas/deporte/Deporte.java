package org.example.practicaspring2.deportistas.deporte;

public class Deporte {

    private String nombre;
    private Integer nivel;

    public Deporte() {
    }

    public Deporte(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
