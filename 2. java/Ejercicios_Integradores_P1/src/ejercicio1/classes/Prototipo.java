package ejercicio1.classes;

public abstract class Prototipo {
    protected Number valor;

    protected Number incremento;

    protected boolean firstCall;

    public Prototipo(Number valor, Number incremento) {
        this.valor = valor;
        this.incremento = incremento;
        this.firstCall = true;
    }

    public Number nextValue(){

        if(firstCall){
            firstCall = false;
            return valor;
        }

        valor = valor.doubleValue() + incremento.doubleValue();
        return valor;
    }

    public abstract void reiniciarSerie();

    public abstract void establecerValorInicial(Number inicio);


}
