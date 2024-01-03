package modelo;

public class Profesores {

    private String nombreMateria;

    public Profesores(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public void ensenar() {
        System.out.println("Enseñando " + this.nombreMateria);
    }

    public void calificar() {
        System.out.println("Calificando " + this.nombreMateria);
    }


}
