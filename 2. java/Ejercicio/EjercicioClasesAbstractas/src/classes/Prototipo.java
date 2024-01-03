package classes;

public abstract class Prototipo<T extends Number>  {

    protected T valorActual;

    public abstract T siguienteValor();

    public abstract void reiniciarSerie();

    public abstract void establecerValorInicial(T valorInicial, T paso);

    public T sumar(T a, T b) {

        if (a == null) {
            return b;
        }
        if (a instanceof Double || b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else if (a instanceof Float || b instanceof Float) {
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        } else {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        }
    }
}
