package clases;

import interfaces.Participante;

public class NaveSimple implements Participante {
    private String nombre;
    private int x, y;
    private int puntuacion=0;

    public NaveSimple(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.puntuacion = puntuacion;
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }

    @Override
    public void recibirPunto() {
        puntuacion++;

    }

    @Override
    public int obtenerPuntuacion() {
        return puntuacion;
    }
    public double calcularDistancia(int X, int Y) {
        return Math.sqrt(Math.pow(x - X, 2) + Math.pow(y - Y, 2));
    }
}
