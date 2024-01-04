import classes.DoubleSerieProgresiva;
import classes.IntSerieProgresiva;

public class Main {
    public static void main(String[] args){
        IntSerieProgresiva intSerieProgresiva = new IntSerieProgresiva();
        intSerieProgresiva.iniciarValorInicial(2);
        System.out.println(intSerieProgresiva.getValorActual());
        intSerieProgresiva.siguienteValor();
        System.out.println(intSerieProgresiva.getValorActual());
        intSerieProgresiva.siguienteValor();
        System.out.println(intSerieProgresiva.getValorActual());

        DoubleSerieProgresiva doubleSerieProgresiva = new DoubleSerieProgresiva();
        doubleSerieProgresiva.iniciarValorInicial(2D);
        System.out.println(doubleSerieProgresiva.getValorActual());
        doubleSerieProgresiva.siguienteValor();
        System.out.println(doubleSerieProgresiva.getValorActual());
        doubleSerieProgresiva.siguienteValor();
        System.out.println(doubleSerieProgresiva.getValorActual());
    }
}

