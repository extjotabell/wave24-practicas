package ejercicio1.classes;

import ejercicio1.interfaces.SoporteTecnico;

public class EstudianteTecnico extends EstudianteRegular implements SoporteTecnico {

    private String especialidad;

    public EstudianteTecnico(String especialidad, String carrera, int anioCursada, String nombre, String apellido, int edad, String dni) {
        super(carrera, anioCursada, nombre, apellido, edad, dni);
        this.especialidad = especialidad;
    }

    public EstudianteTecnico() {
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
