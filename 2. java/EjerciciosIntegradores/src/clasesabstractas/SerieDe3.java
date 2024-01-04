package clasesabstractas;

public class SerieDe3 extends Serie {
    public SerieDe3(Integer valorInicial) {
        super(valorInicial);
    }

    public SerieDe3() {
        super();
    }

    public Integer getValorSiguiente() {
        this.valorActual += 3;
        return this.valorActual;
    }
}
