package ejercicio1.classes;

public class Serie extends Prototipo{

    private Number valorInicial;

    public Serie(Number valor, Number incremento) {
        super(valor, incremento);
        this.valorInicial = valor;
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
