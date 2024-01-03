import classes.Iterador;
import classes.IteradorImpar;
import classes.Prototipo;

public class Main {
    public static void main(String[] args) {


        Prototipo iterador1 = new Iterador();
        Prototipo iterador2 = new IteradorImpar();

        iterador1.establecerValorInicial(2);
        iterador2.establecerValorInicial(1);


        System.out.println("Iterador con serie 2: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(iterador1.devolverSiguiente());
        }

        iterador1.reiniciarSerie();
        iterador1.establecerValorInicial(3);
        System.out.println("Iterador con serie 3: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(iterador1.devolverSiguiente());
        }
        System.out.println("Iterador con serie 1: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(iterador2.devolverSiguiente());
        }
    }
}