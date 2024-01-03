package classes;

public class ClaseA <T extends Number> extends Prototipo<T> {

    private T paso;

    public ClaseA(T paso) {
        this.paso = paso;
    }
    @Override
    public T siguienteValor() {
        T siguiente = sumar(valorActual, paso);
        valorActual = siguiente;
        return siguiente;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = null;
    }

    @Override
    public void establecerValorInicial(T valorInicial, T paso) {
        valorActual = valorInicial;
        this.paso = paso;
    }


}
