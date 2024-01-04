package ejercicio1.classes;

import ejercicio1.interfaces.SoporteTecnico;

public class PersonalTecnico extends Personal implements SoporteTecnico {

    private String especialidad;

    public PersonalTecnico(String especialidad, String cargo, double sueldo, String nombre, String apellido, int edad, String dni) {
        super(cargo, sueldo, nombre, apellido, edad, dni);
        this.especialidad = especialidad;
    }

    public PersonalTecnico() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void reparar() {
        System.out.println("Reparando...");
    }
}
