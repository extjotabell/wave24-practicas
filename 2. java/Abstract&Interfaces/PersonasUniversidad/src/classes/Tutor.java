package classes;

public class Tutor extends Estudiante {

    private String materiaTutor;

    public Tutor(String nombre, String apellidos, int edad, int id, String materiaTutor) {
        super(nombre, apellidos, edad, id);
    }

    public String getMateriaTutor() {
        return materiaTutor;
    }

    public void setMateriaTutor(String materiaTutor) {
        this.materiaTutor = materiaTutor;
    }

    @Override
    public String actividad() {
        return "Enseñar"+materiaTutor;
    }

}
