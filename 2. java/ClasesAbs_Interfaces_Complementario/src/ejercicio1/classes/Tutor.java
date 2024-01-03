package ejercicio1.classes;

import ejercicio1.interfaces.Empleado;
import ejercicio1.interfaces.Estudiante;

public class Tutor extends EstudianteRegular implements Empleado {

    private String materia;

    public Tutor(String materia, String carrera, int anioCursada, String nombre, String apellido, int edad, String dni) {
        super(carrera, anioCursada, nombre, apellido, edad, dni);
        this.materia = materia;
    }

    public Tutor() {
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public void trabajar() {
        System.out.println("Haciendo tutoria...");
    }

    @Override
    public void cobrar() {
        System.out.println("Cobrando...");
    }

    @Override
    public void marcarHorario() {
        System.out.println("Marcando horario...");
    }
}
