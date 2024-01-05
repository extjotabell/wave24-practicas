package classes;

public class Profesores extends Personas{

    public String directorMateria;
    public Profesores(String firstName, String lastName, String identificationDocument, int age) {
        super(firstName, lastName, identificationDocument, age);
    }

    public String getDirectorMateria() {
        return directorMateria;
    }

    public void setDirectorMateria(String directorMateria) {
        this.directorMateria = directorMateria;
    }

    @Override
    public String tareas() {
        return "Dictar clases";
    }
}
