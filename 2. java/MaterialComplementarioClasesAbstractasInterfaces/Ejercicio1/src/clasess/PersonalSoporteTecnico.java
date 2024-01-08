package clasess;

import interfaces.SoporteTecnico;

public class PersonalSoporteTecnico extends Persona implements SoporteTecnico {
    public PersonalSoporteTecnico(String nombre, String apellido, Integer edad) {
        super(nombre, apellido, edad);
    }

    @Override
    public void tipoPersonal() {
        System.out.println("Personal de soporte técnico");
    }

    @Override
    public void realizarSoporte() {
        System.out.println("Realizando soporte técnico...");
    }
}