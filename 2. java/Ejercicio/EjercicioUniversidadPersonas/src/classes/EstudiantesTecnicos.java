package classes;

public class EstudiantesTecnicos extends Estudiantes {

    public EstudiantesTecnicos(String firstName, String lastName, String identificationDocument, int age) {
        super(firstName, lastName, identificationDocument, age);
    }

    @Override
    public String hacerAlgo() {
        return "Colaborar con soporte tecnico";
    }

    @Override
    public String tareas() {
        return "Tareas de estudiante técnico";
    }
}
