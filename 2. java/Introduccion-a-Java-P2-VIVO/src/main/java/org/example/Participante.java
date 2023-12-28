package org.example;

public class Participante {
    int numeroInscripcion;
    int dni;
    String nombre;
    String apellido;
    int edad;
    String celular;
    String numeroEmergencia;
    String grupoSanguineo;

    Participante(int numeroInscripcion, int dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numeroInscripcion = numeroInscripcion;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}
