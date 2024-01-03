package ejercicio1.classes;

import ejercicio1.interfaces.Empleado;

public class Profesor extends Personal implements Empleado {

    private String materia;

    public Profesor(String materia, String cargo, double sueldo, String nombre, String apellido, int edad, String dni) {
        super(cargo, sueldo, nombre, apellido, edad, dni);
        this.materia = materia;
    }

    public Profesor() {
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public void trabajar() {
        System.out.println("Trabajando...");
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
