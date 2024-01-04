package classes;

public class SerieProgresiva <T extends Number>{
    private T valorActual;
    private T valorInicial;

    public SerieProgresiva (){
        this.valorActual = null;
        this.valorInicial = null;
    }

    public T siguienteValor(){
        if(valorActual instanceof Integer){
            valorActual = (T) Integer.valueOf(valorActual.intValue() + valorInicial.intValue());
        } else if (valorActual instanceof Double){
            valorActual = (T) Double.valueOf(valorActual.doubleValue() + valorInicial.doubleValue());
        } else if (valorActual instanceof Float){
            valorActual = (T) Float.valueOf(valorActual.floatValue() + valorInicial.floatValue());
        }

        return valorActual;
    }

    public void reiniciarSerie(){
        valorActual = null;
        valorInicial = null;
    }

    public void iniciarValorInicial(T valorInicial){
        this.valorActual = valorInicial;
        this.valorInicial = valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }
}
