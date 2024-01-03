package modelo;

public class Tutores implements Estudiante{

    private String nombre;

    public Tutores(String nombre) {
        this.nombre = nombre;
    }

    public void ensenar() {
        System.out.println("Enseñando");
    }

    public void calificar() {
        System.out.println("Calificando");
    }

    public void tutoriar() {
        System.out.println("Tutoriando");
    }

    @Override
    public void estudiar() {
        System.out.println("Estudiando");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo");
    }

    @Override
    public void dormir() {
        System.out.println("Durmiendo");
    }

    @Override
    public void reprobar() {
        System.out.println("Reprobando");
    }

    @Override
    public void aprobar() {
        System.out.println("Aprobando");
    }
}
