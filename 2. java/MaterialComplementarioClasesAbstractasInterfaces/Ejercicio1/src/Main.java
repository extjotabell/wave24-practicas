import clasess.*;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Marcos", "Anzurez", 28);
        System.out.println(estudiante.toString());
        Tutor tutor = new Tutor(estudiante);
        System.out.println(tutor.toString());
        tutor.tipoPersonal();
        tutor.darClase();

        Estudiante nuevoEstudiante = new Estudiante("Carlos", "Jimenez", 25);
        System.out.println(nuevoEstudiante);
        EstudianteTecnico estudianteTecnico = new EstudianteTecnico(nuevoEstudiante);
        System.out.println(estudianteTecnico.toString());
        estudianteTecnico.tipoPersonal();
        estudianteTecnico.realizarSoporte();
    }
}