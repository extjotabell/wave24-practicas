package classes;

public class SoporteTecnico extends Personas{
    public SoporteTecnico(String firstName, String lastName, String identificationDocument, int age) {
        super(firstName, lastName, identificationDocument, age);
    }

    @Override
    public String tareas() {
        return "Soporte tecnico variado";
    }
}
