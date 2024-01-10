package com.deportistas.deportistas.classes;

public class Persona {
    private final String nombre;
    private final String apellido;
    private final Integer edad;

    public Persona(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public String fullName(){
        return nombre + " " + apellido;
    }


}
