package clasesabstractas;

public abstract class Serie {
    public Integer valorInicial;
    public Integer valorActual;

    public Serie(Integer valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public Serie() {
        this.valorInicial = 0;
        this.valorActual = 0;
    }

    public abstract Integer getValorSiguiente();

    public void reiniciar() {
        this.valorActual = this.valorInicial;
    }

    public void setValorInicial(Integer valorInicial){
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    };
}
