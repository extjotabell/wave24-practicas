package org.example;

import org.example.ejercicios.clasesAbstractas.SerieProgresiva;
import org.example.ejercicios.clasesAbstractas.SerieProgresivaDobles;
import org.example.ejercicios.clasesAbstractas.SerieProgresivaEnteros;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SerieProgresivaEnteros serieEnteros = new SerieProgresivaEnteros(2);
        serieEnteros.establecerValorInicial(2);
        imprimirSerie(serieEnteros);

        SerieProgresivaEnteros nuevaSerieEnteros = new SerieProgresivaEnteros(1);
        nuevaSerieEnteros.establecerValorInicial(3);
        imprimirSerie(nuevaSerieEnteros);

        SerieProgresivaDobles serieDobles = new SerieProgresivaDobles(3.0);
        serieDobles.establecerValorInicial(3D);
        imprimirSerie(serieDobles);
    }

    private static void imprimirSerie(SerieProgresiva<?> serie) {
        for (int i = 1; i <= 4; i++) {
            System.out.println("Serie " + i  + ": " + serie.valorSiguiente());
        }
        System.out.println();
    }

}