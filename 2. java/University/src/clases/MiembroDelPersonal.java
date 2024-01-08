package clases;

public class MiembroDelPersonal extends Persona{
    private String cargo;
    private double salario;

    public MiembroDelPersonal(String nombre, String apellido, int edad, String id, String celular, String cargo, double salario) {
        super(nombre, apellido, edad, id, celular);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
