package classes;

public class PersonalDeMantenimiento extends MiembroDelPersonal{

    public PersonalDeMantenimiento(String nombre, String apellidos, int edad, int id, Double sueldo) {
        super(nombre, apellidos, edad, id, sueldo);
    }

    @Override
    public String actividad() {
        return "Hacer mantenimiento";
    }
}
