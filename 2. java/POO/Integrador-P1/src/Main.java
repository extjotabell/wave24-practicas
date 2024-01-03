import Clases.Iterador;
import Clases.IteradorImpar;
import Clases.Prototipo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Prototipo iterador1 = new Iterador();
        Prototipo iterador2 = new IteradorImpar();

        iterador1.establecerValorInicial(2);
        iterador2.establecerValorInicial(1);


        for (int i = 0; i < 10; i++) {
            System.out.println("iterador con serie 2: " + iterador1.devolverSiguiente());
        }

        iterador1.reiniciarSerie();
        iterador1.establecerValorInicial(3);
        for (int i = 0; i < 10; i++) {
            System.out.println("iterador con serie 3: " + iterador1.devolverSiguiente());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("iterador con serie 1: " + iterador2.devolverSiguiente());
        }
    }
}