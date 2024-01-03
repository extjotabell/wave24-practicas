package Clases;

public class IteradorImpar extends Prototipo {

    @Override
    public Integer devolverSiguiente() {

        return valorActual += 2;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 1;
    }

    @Override
    public void establecerValorInicial(Integer numero) {
        if(numero == 1){
            valorActual = numero;
        }
        else{
            System.out.println("valor invalido");
        }
    }
}
