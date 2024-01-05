package classes;

import interfaces.IPersonas;

public abstract class Estudiantes extends Personas {
    public String materia;

    public Estudiantes(String firstName, String lastName, String identificationDocument, int age) {
        super(firstName, lastName, identificationDocument, age);
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public abstract String hacerAlgo();

    @Override
    public String toString() {
        return "Estudiantes{" +
                "materia='" + materia + '\'' +
                '}';
    }
}
