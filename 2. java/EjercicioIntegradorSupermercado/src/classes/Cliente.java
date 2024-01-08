package classes;

public class Cliente {
    //Variables
    private String dni;
    private String Nombre;
    private String Apellido;

    //Constructor
    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        Nombre = nombre;
        Apellido = apellido;
    }

    //Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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


    //ToString
    @Override
    public String toString() {
        return "Cliente{" +
                "DNI='" + dni + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                '}';
    }
}
