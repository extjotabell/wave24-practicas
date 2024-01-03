import classes.ClaseA;
import classes.ClaseB;

public class Main {
    public static void main(String[] args) {

        ClaseA<Double> claseA = new ClaseA<>(2.0);
        ClaseB<Integer> claseB = new ClaseB<>(3);

        for (int i = 0; i < 6; i++) {
            System.out.println("ClaseA: " + claseA.siguienteValor());
            System.out.println("ClaseB: " + claseB.siguienteValor());
            if (i == 2) { //probar el reiniciar serie
                claseB.reiniciarSerie();
            }
        }

        claseB.establecerValorInicial(1,2);
        claseA.establecerValorInicial(1.0,2.0);

        for (int i = 0; i < 4; i++) {
            System.out.println("Clase B con valor inicial "+ (i+1) +" : " + claseB.siguienteValor());
        }
    }
}