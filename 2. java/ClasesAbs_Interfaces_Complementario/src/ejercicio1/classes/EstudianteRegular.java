package ejercicio1.classes;


import ejercicio1.interfaces.Estudiante;

public class EstudianteRegular extends Persona implements Estudiante {

    private String carrera;
    private int anioCursada;

    public EstudianteRegular(String carrera, int anioCursada, String nombre, String apellido, int edad, String dni) {
        super(nombre, apellido, edad, dni);
        this.carrera = carrera;
        this.anioCursada = anioCursada;
    }

    public EstudianteRegular() {
    }

    @Override
    public void estudiar() {
        System.out.println("Estudiando...");
    }

    @Override
    public void hacerTarea() {
        System.out.println("Haciendo tarea...");
    }

    @Override
    public void marcarAsistencia() {
        System.out.println("Marcando asistencia...");
    }
}
