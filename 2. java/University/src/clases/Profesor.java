package clases;

public class Profesor extends Persona{
    private String asignatura;

    public Profesor(String nombre, String apellido, int edad, String id, String celular, String asignatura) {
        super(nombre, apellido, edad, id, celular);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
