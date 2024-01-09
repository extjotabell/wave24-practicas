package Variables;

import java.util.*;

public class Collecciones {
    public static void main(String[] args) {
        //API COLLECTIONS
        //ARREGLOS : SLO SON RAPIDOS PERO NO PERMITEN MUTABILIDAD
        //VECTORES : HILOS , Y PROCESOS SON SEGUROS , RENDIMIENTO EXTRA
        //LISTAS ENLAZADAS : MANTIENEN EL ORDEN ASI SE BORRE COMO PILA Y COLA
        List<String> l = new ArrayList<>();
        l.add("hola");
        l.add("mundo");
        l.add("hola");
        l.add("Anderson");
        System.out.println("LISTA ");
        System.out.println(l);
        Collections.sort(l);
        System.out.println(l);

        //METODOS : EQUALS , CONTINES, REMOVE

        //SETS : NO DUPLICADOS
        //HASHSET : NO ORDEN , MAS HABITUAL , HASH CODE
        //TREESET : ORDEN , MAS LENTO Y RENDIMIENTO
        //LINKENDHASHED :  HASHSET Y LINKENDLIST ,
        System.out.println("SET");
        Set<String> h = new HashSet<>();
        h.add("hola");
        h.add("mundo");
        h.add("hola");
        h.add("Anderson");
        System.out.println(h);
        System.out.println(h.size());
        System.out.println(h.isEmpty());


        //parsear

        List<String> l2 = new ArrayList<>(h);
        Collections.sort(l2);
        System.out.println(l2);



        //THREE SET COSTO DE RENDIMIENTO
        System.out.println("Treeset ");
        Set<String> t = new TreeSet<>();
        t.add("Hola");
        t.add("Mundo");
        t.add("Hola");
        t.add("Anderson");
        t.add("Nicolas");

        System.out.println(t);

        //programacion funcional
        Set<Integer> si = new TreeSet<Integer>(Comparator.reverseOrder());
        si.add(1);
        si.add(2);
        si.add(3);
        si.add(4);
        si.add(5);
        System.out.println(si);

        //MAP : DICCIONARIO
        //HASHMAP: ELEMENTOS UNICOS, DICCIONARIO
        //TREEMAP : IGUAL ORDEN



    }
}
