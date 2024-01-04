package org.example.ejercicios.clasesAbstractas;

public class SerieProgresivaDobles extends SerieProgresiva<Double>{
    public SerieProgresivaDobles(Double paso) {
        super(paso);
    }

    @Override
    protected Double sumar(Double a, Double b) {
        return a + b;
    }
}
