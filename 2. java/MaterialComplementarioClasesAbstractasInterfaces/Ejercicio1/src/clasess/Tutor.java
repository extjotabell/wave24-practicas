package clasess;

import interfaces.Docente;

public class Tutor extends Estudiante implements Docente {
    public Tutor(Estudiante estudiante) {
        super(estudiante.getNombre(), estudiante.getApellido(), estudiante
                .getEdad());
    }

    @Override
    public void darClase() {
        System.out.println("Tutor enseñando algo...");
    }

    @Override
    public void tipoPersonal() {
        System.out.println("Tutor");
    }
}