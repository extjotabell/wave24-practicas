package org.example.ejercicios.clasesAbstractas;

import org.example.ejercicios.clasesAbstractas.models.SerieProgresiva;
import org.example.ejercicios.clasesAbstractas.models.SerieProgresivaDobles;
import org.example.ejercicios.clasesAbstractas.models.SerieProgresivaEnteros;

public class ClasesAbstractas {

    public void main(){

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

    private void imprimirSerie(SerieProgresiva<?> serie) {
        for (int i = 1; i <= 4; i++) {
            System.out.println("Serie " + i  + ": " + serie.valorSiguiente());
        }
        System.out.println();
    }
}
