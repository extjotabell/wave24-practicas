package ejercicio_series_numericas;

public abstract class SerieNumerica<T extends Number> {
    protected T valorInicial;
    protected T valorActual;

    public SerieNumerica(T valorInicial) {
        this.valorInicial = valorInicial;
        reiniciarSerie();
    }

    public abstract T obtenerSiguiente();

    public void reiniciarSerie() {
        valorActual = valorInicial;
    }

    public void establecerValorInicial(T nuevoValorInicial) {
        valorInicial = nuevoValorInicial;
        reiniciarSerie();
    }
}