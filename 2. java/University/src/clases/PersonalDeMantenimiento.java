package clases;

public class PersonalDeMantenimiento extends Persona{
    private String areasAsignadas;
    private String tarea;

    public PersonalDeMantenimiento(String nombre, String apellido, int edad, String id, String celular, String areasAsignadas, String tarea) {
        super(nombre, apellido, edad, id, celular);
        this.areasAsignadas = areasAsignadas;
        this.tarea = tarea;
    }

    public String getAreasAsignadas() {
        return areasAsignadas;
    }

    public void setAreasAsignadas(String areasAsignadas) {
        this.areasAsignadas = areasAsignadas;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
}
