package clases;

import interfaces.Participante;

import java.util.ArrayList;
import java.util.List;

public class FlotaDeNaves implements Participante {
    private String nombre;
    private List<Participante> naves;

    public FlotaDeNaves(String nombre) {
        this.nombre = nombre;
        this.naves = new ArrayList<>();;
    }
    public void agregarNave(Participante nave) {
        naves.add(nave);
    }
    @Override
    public String obtenerNombre() {
        return nombre;
    }

    @Override
    public void recibirPunto() {
        for (Participante nave : naves) {
            nave.recibirPunto();
        }
    }
    @Override
    public int obtenerPuntuacion() {
        int totalPuntos = naves.stream().mapToInt(Participante::obtenerPuntuacion).sum();
        return naves.isEmpty() ? 0 : totalPuntos / naves.size();
    }
    public Participante obtenerNaveGanadora(int X, int Y) {
        double distanciaMinima = Double.MAX_VALUE;
        Participante naveGanadora = null;

        for (Participante nave : naves) {
            double distancia = ((NaveSimple) nave).calcularDistancia(X, Y);
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                naveGanadora = nave;
            }
        }
        return naveGanadora;
    }
}
