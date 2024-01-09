package Variables;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Alumno implements Comparable<Alumno> { //implementando una interfaz : tiene metodos

    private String nombre;
    private int nota;


    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';


    }
    @Override
    public int compareTo(Alumno a) {
        return this.nombre.compareTo(a.nombre);
    }


    public static void main(String[] args) {

        //guardar alunmos

        Set<Alumno> lista = new TreeSet<Alumno>();
        lista.add(new Alumno("Juan", 10));
        lista.add(new Alumno("Ander", 50));
        lista.add(new Alumno("Pedro", 80));
        lista.add(new Alumno("Lucy", 90));
        lista.add(new Alumno("Angel", 100));

        System.out.println(lista);
        lista.forEach(a -> System.out.println(a));
        lista.forEach(System.out::println);
    }

    //formas de recorrer un arraylist
    //foreach
    //iterator y while


}
