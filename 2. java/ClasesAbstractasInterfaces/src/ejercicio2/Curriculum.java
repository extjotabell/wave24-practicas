package ejercicio2;

import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    private String telefono;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String telefono, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nTelefono: " + this.telefono + "\nHabilidades: " + this.habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum...");
        System.out.println(this.toString() + "\n");
    }
}
