package com.ejemplo.practica;

public record EstudianteRecord(Integer id, String nombre, String apellido, String pais) {
    public void nashe(){
        System.out.println("hola");
    }

}
