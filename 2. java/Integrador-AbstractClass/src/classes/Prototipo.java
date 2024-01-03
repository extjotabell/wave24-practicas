package classes;

public abstract class Prototipo {
    protected Integer valorActual = 0;

    public abstract Integer devolverSiguiente();
    public abstract void reiniciarSerie();
    public abstract void establecerValorInicial(Integer numero);

}