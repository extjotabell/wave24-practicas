import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EstructurasDinamicas {

    public static  void main (String[] args) {
        // ArrayList

        // Declarar
        ArrayList<String> listaPersonas = new ArrayList<>();
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String> stringList2 = new ArrayList<>(5);

        System.out.println(stringList.size());
        System.out.println(stringList2.size());

        // Cargar
        listaPersonas.add("Cristiano Ronaldo");
        listaPersonas.add("Liones Messi");


        // Recorrido

        // Forma 1
        for (String person : listaPersonas) {
            // System.out.println("Hola soy: " + person);
        }

        // forma 2
        for (int i = 0; i < listaPersonas.size(); i++){
            // System.out.println("Hola soy: " + listaPersonas.get(i));
        }

        // LinkedList
        LinkedList<String> stringList3 = new LinkedList<>();
        stringList3.addFirst("Yoiber");
        stringList3.addLast("Juan");
        System.out.println(stringList);
    }



}
