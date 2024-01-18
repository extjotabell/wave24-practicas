package com.ejemplo.practica;

public class EstudiantePOJO {

    private final Integer id;

    private final String nombre;

    private final String apellido;

    private final String pais;


    public EstudiantePOJO(Integer id, String nombre, String apellido, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public String getPais() {
        return pais;
    }


    @Override
    public String toString() {
        return "EstudiantePOJO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

}
