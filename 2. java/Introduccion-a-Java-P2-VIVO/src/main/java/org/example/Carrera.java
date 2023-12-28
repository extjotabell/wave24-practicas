package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carrera {
    ArrayList<Categoria> categorias = new ArrayList<>();
    ArrayList<Inscripcion> inscripciones = new ArrayList<>();

    List<Categoria> crearCategorias() {
        categorias.add(new Categoria(1, "Circuito chico", "2 km por selva y arroyos"));
        categorias.add(new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro"));
        categorias.add(new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra"));
        return categorias;
    }

    void inscribirParticipante(Categoria categoria, Participante participante) {
        int monto = calcularMontoInscripcion(categoria, participante.edad);
        int numeroInscripcion = inscripciones.size() + 1;
        if (monto != 0) {
            Inscripcion inscripcion = new Inscripcion(numeroInscripcion, categoria, participante, monto);
            inscripciones.add(inscripcion);
        }
    }

    int calcularMontoInscripcion(Categoria categoria, int edad) {
        if (categoria.id == 1) {
            return (edad < 18) ? 1300 : 1500;
        } else if (categoria.id == 2) {
            return (edad < 18) ? 2000 : 2300;
        } else if (categoria.id == 3) {
            return (edad >= 18) ? 2800 : 0;
        }
        return 0;
    }

    void inscribirParticipantesAlAzar() {
        Random rand = new Random();
        for (Categoria categoria : categorias) {
            int cantidadParticipantes = rand.nextInt(5) + 1;
            for (int i = 0; i < cantidadParticipantes; i++) {
                Participante participante = new Participante(
                        inscripciones.size() + 1,
                        rand.nextInt(1000000000),
                        "Nombre" + i,
                        "Apellido" + i,
                        rand.nextInt(40) + 10,
                        "123456789",
                        "987654321",
                        "A"
                );
                inscribirParticipante(categoria, participante);
            }
        }
    }

    void mostrarParticipantesPorCategoria(Categoria categoria) {
        System.out.println("Participantes en la categoría " + categoria.nombre + ":");
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.categoria == categoria) {
                Participante participante = inscripcion.participante;
                System.out.println("Número de inscripción: " + inscripcion.numeroInscripcion);
                System.out.println("Nombre: " + participante.nombre + " " + participante.apellido);
                System.out.println("Edad: " + participante.edad + " años");
                System.out.println("Monto abonado: $" + inscripcion.monto);
                System.out.println("--------------------");
            }
        }
    }

    void desinscribirParticipante(int numeroInscripcion) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.numeroInscripcion == numeroInscripcion) {
                inscripciones.remove(inscripcion);
                break;
            }
        }
    }

    void calcularMontoTotalRecaudado() {
        int totalCircuitoChico = 0;
        int totalCircuitoMedio = 0;
        int totalCircuitoAvanzado = 0;
        int montoTotalCarrera = 0;

        for (Inscripcion inscripcion : inscripciones) {
            switch (inscripcion.categoria.id) {
                case 1:
                    totalCircuitoChico += inscripcion.monto;
                    break;
                case 2:
                    totalCircuitoMedio += inscripcion.monto;
                    break;
                case 3:
                    totalCircuitoAvanzado += inscripcion.monto;
                    break;
            }
            montoTotalCarrera += inscripcion.monto;
        }

        System.out.println("Monto total recaudado en Circuito Chico: $" + totalCircuitoChico);
        System.out.println("Monto total recaudado en Circuito Medio: $" + totalCircuitoMedio);
        System.out.println("Monto total recaudado en Circuito Avanzado: $" + totalCircuitoAvanzado);
        System.out.println("Monto total recaudado en toda la carrera: $" + montoTotalCarrera);
    }
}
