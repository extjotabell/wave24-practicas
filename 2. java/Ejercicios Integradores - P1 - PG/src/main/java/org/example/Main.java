package org.example;

import org.example.ejercicios.clasesAbstractas.ClasesAbstractas;
import org.example.ejercicios.integrador.Integrador;

public class Main {
    public static void main(String[] args) {

        ClasesAbstractas clasesAbstractas = new ClasesAbstractas();
        clasesAbstractas.main();
        Integrador integrador = new Integrador();
        integrador.main();
    }

}