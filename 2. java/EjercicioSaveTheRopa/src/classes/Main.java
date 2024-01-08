package classes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Marca1", "Modelo1");
        Prenda prenda2 = new Prenda("Marca2", "Modelo2");
        List<Prenda> listaPrendas = new ArrayList<>();
        List<Prenda> listaPrendas2 = new ArrayList<>();
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);
        listaPrendas2.add(prenda2);


        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(listaPrendas);
        guardaRopa.guardarPrendas(listaPrendas2);

        guardaRopa.mostrarPrendas();

        List<Prenda> nuevaListaPrendas;
        Integer id = 2;
        nuevaListaPrendas = guardaRopa.devolverPrendas(id);
        System.out.println("Lista de prendas en número " + id + " " + nuevaListaPrendas);

    }
}
