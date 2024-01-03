package ejercicio1.classes;

public class Personal extends Persona {

    private String cargo;
    private double sueldo;

    public Personal(String cargo, double sueldo, String nombre, String apellido, int edad, String dni) {
        super(nombre, apellido, edad, dni);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public Personal() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
