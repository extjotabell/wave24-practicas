package ejercicio_series_numericas;

public class SerieProgresiva extends SerieNumerica<Integer> {
    private int incremento;

    public SerieProgresiva(int valorInicial, int incremento) {
        super(valorInicial);
        this.incremento = incremento;
    }

    @Override
    public Integer obtenerSiguiente() {
        int siguiente = valorActual + incremento;
        valorActual = siguiente;
        return siguiente;
    }
}

