import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("ArrayList");
        ArrayList al = new ArrayList();
        System.out.println("1. Método .add");
        al.add("Diego");
        al.add(28);
        al.add(null);
        System.out.println(al);
        System.out.println("2. Método .set(Posicion, Dato)");
        al.set(2,13);
        System.out.println(al);
        System.out.println("3. Método .add(index,element)");
        System.out.println("Agrega y desplaza elemento +1 si hay algo en memoria");
        al.add(2,true);
        System.out.println(al);
        System.out.println("4. Recorrido");
        for (Object e : al){
            System.out.println(e);
        }
        System.out.println(al);
        System.out.println("End");
        System.out.println("-------------------------------------");

        System.out.println("LinkedList");
        LinkedList l = new LinkedList<>();
        System.out.println("1. Método .add");
        l.add("Diego");
        l.add(28);
        l.add(null);
        System.out.println(l);
        //(Posicion, Dato)
        System.out.println("2. Método .set(Posicion, Dato)");
        l.set(2,13);
        System.out.println(l);
        System.out.println("3. Método .add(index,element)");
        l.add(2,true);
        System.out.println(l);
        System.out.println("4. Método .remoleLast, elimina el ultimo elemento");

        l.removeLast();
        System.out.println(l);
        System.out.println("5. Método .addFirst, agrega la primera posición");
        l.addFirst(1);
        System.out.println(l);
        System.out.println("End");
        System.out.println("-------------------------------------");

        System.out.println("Map");
        Map<Integer,String> mapa =new HashMap<>();
        System.out.println("1. Método .put");
        mapa.put(1,"Uno");
        mapa.put(2,"Dos");
        mapa.put(3,"Tres");
        System.out.println(mapa);
        System.out.println("2. Método .remove(key = 2)");
        System.out.println("elimina elemento segun key");
        mapa.remove(2);
        System.out.println(mapa);
        System.out.println("3. Recorrido");
        for(Map.Entry<Integer,String> entrada :mapa.entrySet()){
            Integer clave = entrada.getKey();
            String valor = entrada.getValue();
            System.out.println("La clave es: "+ clave + " el valor es: "+ valor );
        }
        System.out.println(mapa);
        System.out.println("End");

    }
}