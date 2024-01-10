package classes;

public class Profesor extends Persona {

    private String Area;

    public Profesor(String nombre, String apellidos, int edad, int id) {
        super(nombre, apellidos, edad, id);
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    @Override
    public String actividad() {
        return "Dictar clase";
    }
}
