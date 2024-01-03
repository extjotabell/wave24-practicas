package modelo;

public class PersonalMantenimiento {

    private String nombre;

    public PersonalMantenimiento(String nombre) {
        this.nombre = nombre;
    }

    public void limpiar() {
        System.out.println("Limpiando");
    }

    public void reparar() {
        System.out.println("Reparando");
    }
}
