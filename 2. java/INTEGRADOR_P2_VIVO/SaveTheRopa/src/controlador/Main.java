package controlador;

import modelo.GuardaRopa;
import modelo.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Nike", "Air Force 1");
        Prenda prenda2 = new Prenda("Adidas", "Superstar");
        Prenda prenda3 = new Prenda("Puma", "Suede");

        Prenda prenda4 = new Prenda("Reebok", "Classic");

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();

        prendas.add(prenda1);
        prendas.add(prenda2);

        guardaRopa.guardarPrendas(prendas);

        guardaRopa.guardarPrendas(List.of(prenda3));

        System.out.println("Prendas guardadas: ");

        guardaRopa.mostrarPrendas();

        System.out.println("---------------------------------\n");
        System.out.println("Prendas devueltas: ");

        List<Prenda> diccionario = guardaRopa.devolverPrendas(1);

        diccionario.forEach(
                prenda -> {
                    System.out.println("Marca: " + prenda.getMarca());
                    System.out.println("Modelo: " + prenda.getModelo());
                }
        );


    }

}
