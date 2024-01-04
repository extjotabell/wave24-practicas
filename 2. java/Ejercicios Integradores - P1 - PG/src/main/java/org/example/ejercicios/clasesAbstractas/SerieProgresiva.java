package org.example.ejercicios.clasesAbstractas;

public abstract class SerieProgresiva <T extends Number>{

    T valorInicial;
    T valorActual;
    T paso;

    public SerieProgresiva(T paso) {
        this.paso = paso;
    }

    public T valorSiguiente() {
        T resultado = valorActual;
        valorActual = sumar(valorActual, paso);
        return resultado;
    }

    public void reiniciarSerie() {
        valorActual = valorInicial;
    }

    public void establecerValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        reiniciarSerie();
    }

    protected abstract T sumar(T a, T b);
}
