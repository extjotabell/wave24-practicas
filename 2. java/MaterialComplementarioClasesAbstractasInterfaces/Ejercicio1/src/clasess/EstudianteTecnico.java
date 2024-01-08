package clasess;

import interfaces.SoporteTecnico;

public class EstudianteTecnico extends Estudiante implements SoporteTecnico {
    public EstudianteTecnico (Estudiante estudiante) {
        super(estudiante.getNombre(), estudiante.getApellido(), estudiante.getEdad());
    }

    @Override
    public void tipoPersonal() {
        System.out.println("Estudiante Técnico");
    }

    @Override
    public void realizarSoporte() {
        System.out.println("Ayudando a soporte técnico...");
    }
}