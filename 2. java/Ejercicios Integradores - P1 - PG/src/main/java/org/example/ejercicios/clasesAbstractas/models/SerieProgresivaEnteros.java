package org.example.ejercicios.clasesAbstractas.models;

public class SerieProgresivaEnteros extends SerieProgresiva<Integer> {
    public SerieProgresivaEnteros(Integer paso) {
        super(paso);
    }

    @Override
    protected Integer sumar(Integer a, Integer b) {
        return a + b;
    }
}
