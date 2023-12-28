package org.example;

public class Inscripcion {
    int numeroInscripcion;
    Categoria categoria;
    Participante participante;
    int monto;

    Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante, int monto) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
    }
}
