package classes;

public class Tutores extends Estudiantes{

    public Tutores(String firstName, String lastName, String identificationDocument, int age) {
        super(firstName, lastName, identificationDocument, age);
    }

    @Override
    public String hacerAlgo() {
        return "Enseñamos cosas";
    }

    @Override
    public String tareas() {
        return "Tareas de tutores";
    }
}
