package classes;

public class MiembrosPersonal extends Personas{
    public MiembrosPersonal(String firstName, String lastName, String identificationDocument, int age) {
        super(firstName, lastName, identificationDocument, age);
    }

    @Override
    public String tareas() {
        return "Reuniones";
    }
}
