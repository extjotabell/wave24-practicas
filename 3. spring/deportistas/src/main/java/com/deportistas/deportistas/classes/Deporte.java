package com.deportistas.deportistas.classes;

public class Deporte {
    private final String nombre;
    private final Integer nivel;

    public Deporte(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre: '" + nombre + '\'' +
                ", nivel: " + nivel +
                '}';
    }
}
