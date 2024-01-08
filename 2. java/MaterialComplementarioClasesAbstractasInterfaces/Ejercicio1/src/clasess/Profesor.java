package clasess;

import interfaces.Docente;

public class Profesor extends Persona implements Docente {
    public Profesor(String nombre, String apellido, Integer edad) {
        super(nombre, apellido, edad);
    }

    @Override
    public void tipoPersonal() {
        System.out.println("Profesor");
    }

    @Override
    public void darClase() {
        System.out.println("Profesor enseñando algo...");
    }
}