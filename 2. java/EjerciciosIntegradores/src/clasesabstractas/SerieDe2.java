package clasesabstractas;

public class SerieDe2 extends Serie {
    public SerieDe2(Integer valorInicial) {
        super(valorInicial);
    }

    public SerieDe2() {
        super();
    }

    public Integer getValorSiguiente() {
        this.valorActual += 2;
        return this.valorActual;
    }
}
