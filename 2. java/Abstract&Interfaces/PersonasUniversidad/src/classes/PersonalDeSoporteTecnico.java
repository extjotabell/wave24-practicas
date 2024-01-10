package classes;

public class PersonalDeSoporteTecnico extends MiembroDelPersonal{

    public PersonalDeSoporteTecnico(String nombre, String apellidos, int edad, int id, Double sueldo) {
        super(nombre, apellidos, edad, id, sueldo);
    }
    @Override
    public String actividad() {
        return "Hacer soporte técnico";
    }
}
