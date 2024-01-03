package Clases;

public class Iterador extends Prototipo{

    private int intervalo = 0;

    @Override
    public Integer devolverSiguiente() {
        valorActual = valorActual + intervalo;
        return valorActual;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 0;
    }

    @Override
    public void establecerValorInicial(Integer numero) {
        if(numero == 2 || numero == 3) {
            intervalo = numero;
            valorActual = 0;
        }
        else{
            System.out.println("valor invalido");
        }
    }
}
