package modelo;

public class SoporteTecnico {

    private String nombre;

    public SoporteTecnico(String nombre) {
        this.nombre = nombre;
    }

    public void reparar() {
        System.out.println("Reparando");
    }

    public void limpiar() {
        System.out.println("Limpiando");
    }

    public void ensenar() {
        System.out.println("Enseñando");
    }

    public void calificar() {
        System.out.println("Calificando");
    }

}
