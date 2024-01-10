package classes;

public abstract class Estudiante extends Persona {

    private String materias[];
    public Estudiante(String nombre, String apellidos, int edad, int id) {
        super(nombre, apellidos, edad, id);
    }

    public String[] getMaterias() {
        return materias;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }

    @Override
    public String actividad() {
        return "Estudiar";
    }
}
