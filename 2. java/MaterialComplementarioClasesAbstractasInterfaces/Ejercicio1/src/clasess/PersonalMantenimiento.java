package clasess;

import interfaces.Mantenimiento;

public class PersonalMantenimiento extends Persona implements Mantenimiento {
    public PersonalMantenimiento(String nombre, String apellido, Integer edad) {
        super(nombre, apellido, edad);
    }

    @Override
    public void tipoPersonal() {
        System.out.println("Personal de mantenimiento");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Realizando mantenimiento...");
    }
}