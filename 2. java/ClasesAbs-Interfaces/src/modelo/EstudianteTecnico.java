package modelo;

public class EstudianteTecnico implements Estudiante{

    private String nombre;

    public EstudianteTecnico(String nombre) {
        this.nombre = nombre;
    }

    public void ensenar() {
        System.out.println("Enseñando desde estudiante tecnico");
    }

    public void calificar() {
        System.out.println("Calificando desde estudiante tecnico");
    }

    public void tutoriar() {
        System.out.println("Tutoriando desde estudiante tecnico");
    }

    @Override
    public void estudiar() {
        System.out.println("Estudiando desde estudiante tecnico");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo desde estudiante tecnico");
    }

    @Override
    public void dormir() {
        System.out.println("Durmiendo desde estudiante tecnico");
    }

    @Override
    public void reprobar() {
        System.out.println("Reprobando desde estudiante tecnico");
    }

    @Override
    public void aprobar() {
        System.out.println("Aprobando desde estudiante tecnico");
    }

}
