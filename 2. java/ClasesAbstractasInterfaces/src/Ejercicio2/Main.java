package Ejercicio2;

import java.util.List;

public class Main {

    public static void imprimir(Imprimible imprimible) {
        imprimible.imprimir();
    }

    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Perez", "123456789", List.of("Java", "C++", "Python"));
        Informe informe = new Informe("Juan", "Informe de ventas", "Pedro", 10);
        LibroPDF libro = new LibroPDF("Juan", "Libro de Java", "Programacion", 100);

        imprimir(curriculum);
        imprimir(informe);
        imprimir(libro);
    }
}