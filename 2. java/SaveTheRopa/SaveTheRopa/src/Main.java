package src;
import src.classes.GuardaRopa;
import src.classes.Prenda;

import java.util.List;

    public class Main {

        public static void main(String[] args) {
            // Crear prendas
            Prenda prenda1 = new Prenda("Nike", "Air");
            Prenda prenda2 = new Prenda("Adidas", "Superstar");
            List<Prenda> prendas = List.of(prenda1, prenda2);

            // Crear guardarropas
            GuardaRopa guardaRopa = new GuardaRopa();

            // Guardar prendas
            Integer codigo = guardaRopa.

                    guardarPrendas(prendas);

            // Consultar guardarropas
            System.out.println("Consultar guardarropas por código: " + codigo);
            System.out.println("Número de Guardarropa: " + codigo);
            guardaRopa.devolverPrendas(codigo).forEach(prenda -> System.out.println("\t - " + prenda));
            System.out.println();

            // Mostrar guardarropas
            System.out.println("Mostrar guardarropas");
            guardaRopa.mostrarPrendas();
        }

    }

