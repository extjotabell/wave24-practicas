package classes;

public class EstudianteTecnico extends Estudiante{

    public EstudianteTecnico(String nombre, String apellidos, int edad, int id) {
        super(nombre, apellidos, edad, id);
    }

    @Override
    public String actividad() {
        return "Ayudar en soporte tecnico";
    }
}
