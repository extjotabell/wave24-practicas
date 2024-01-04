package ejercicio1.classes;

public class SerieMultiplicando extends Prototipo{
    private Number valorInicial;

    public SerieMultiplicando(Number valor, Number incremento) {
        super(valor, incremento);
        this.valorInicial = valor;
    }

    @Override
    public Number nextValue(){

        if(firstCall){
            firstCall = false;
            return valor;
        }

        this.valor = this.valor.doubleValue() * this.incremento.doubleValue();
        return this.valor;
    }

    @Override
    public void reiniciarSerie() {
        this.firstCall = true;
        this.valor = this.valorInicial;
    }

    @Override
    public void establecerValorInicial(Number inicio) {
        this.valorInicial = inicio;
        reiniciarSerie();
    }
}
