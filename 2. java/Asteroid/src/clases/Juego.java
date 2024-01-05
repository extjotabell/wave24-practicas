package clases;

import interfaces.Participante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Juego {
    private List<Participante> participantes;

    public Juego(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public void jugar(int[][] coordenadas) {
        Map<Participante, Integer> resultados = new HashMap<>();

        for (int[] coordenada : coordenadas) {
            int x = coordenada[0];
            int y = coordenada[1];

            Participante naveGanadora = null;
            double distanciaMinima = Double.MAX_VALUE;

            for (Participante participante : participantes) {
                double distancia;
                if (participante instanceof FlotaDeNaves) {
                    distancia = ((FlotaDeNaves) participante).obtenerNaveGanadora(x, y)
                            .obtenerPuntuacion();
                } else {
                    distancia = ((NaveSimple) participante).calcularDistancia(x, y);
                }

                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    naveGanadora = participante;
                }
            }

            naveGanadora.recibirPunto();

            resultados.put(naveGanadora, resultados.getOrDefault(naveGanadora, 0) + 1);


            System.out.println("Coordenadas: (" + x + ", " + y + ")");
            for (Participante participante : participantes) {
                System.out.println(participante.obtenerNombre() + ": " + participante.obtenerPuntuacion() + " puntos");
            }
            System.out.println("-------------------------------");
        }

        Participante ganador = participantes.stream()
                .max((p1, p2) -> Integer.compare(resultados.getOrDefault(p1, 0), resultados.getOrDefault(p2, 0)))
                .orElse(null);

        if (ganador != null) {
            System.out.println("¡El ganador es: " + ganador.obtenerNombre() + " con " + ganador.obtenerPuntuacion() + " puntos!");
        } else {
            System.out.println("El juego ha terminado en empate.");
        }
    }

}