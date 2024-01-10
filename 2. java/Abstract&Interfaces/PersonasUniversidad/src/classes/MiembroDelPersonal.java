package classes;

import interfaces.IPersona;

public abstract class MiembroDelPersonal extends Persona {

    private Double sueldo;

    public MiembroDelPersonal(String nombre, String apellidos, int edad, int id, Double sueldo) {
        super(nombre, apellidos, edad, id);
        this.sueldo = sueldo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString()+" [sueldo: "+sueldo+"]";
    }

    @Override
    public String actividad() {
        return "Ir a reunion de personal";
    }
}
