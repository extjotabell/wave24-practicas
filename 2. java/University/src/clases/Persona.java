package clases;

public abstract class Persona {
    private String Nombre;
    private String Apellido;
    private int edad;
    private String id;
    private String Celular;

    public Persona(String nombre, String apellido, int edad, String id, String celular) {
        Nombre = nombre;
        Apellido = apellido;
        this.edad = edad;
        this.id = id;
        Celular = celular;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }
}
