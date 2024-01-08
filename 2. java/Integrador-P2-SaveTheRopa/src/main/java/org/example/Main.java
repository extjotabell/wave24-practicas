package org.example;

import org.example.classes.GuardaRopa;
import org.example.classes.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");
        Prenda prenda3 = new Prenda("Puma", "Zapatillas");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);
        prendas.add(prenda3);

        Integer numeroCasilla = guardaRopa.guardarPrenda(prendas);

        guardaRopa.mostrarRopa();
    }
}