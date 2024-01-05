package classes;

public class PersonalMantenimiento extends Personas {
    private String area;
    public PersonalMantenimiento(String firstName, String lastName, String identificationDocument, int age) {
        super(firstName, lastName, identificationDocument, age);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String tareas() {
        return "Revisar mantenimiento";
    }
}
