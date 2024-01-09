package ejercicio_series_numericas;

public class SerieProgresivaDouble extends SerieNumerica<Double> {
    private double incremento;

    public SerieProgresivaDouble(double valorInicial, double incremento) {
        super(valorInicial);
        this.incremento = incremento;
    }

    @Override
    public Double obtenerSiguiente() {
        double siguiente = valorActual + incremento;
        valorActual = siguiente;
        return siguiente;
    }
}