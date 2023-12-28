package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        List<Categoria> categorias = carrera.crearCategorias();

        Participante participante = new Participante(1, 45084386, "Imanol", "Suppo",
                19, "351 478 1111", "11111111", "B-");

        carrera.inscribirParticipante(categorias.get(0), participante);
        carrera.inscribirParticipantesAlAzar();

        carrera.mostrarParticipantesPorCategoria(categorias.get(0));
        carrera.calcularMontoTotalRecaudado();
    }

}


