package classes;

import classes.interfaces.Imprimible;

import java.util.ArrayList;

public class Curriculum implements Imprimible {
    //Incluye a una persona con todos sus atributos mas una lista de habilidades
    //Variables
    private String nombre;
    private String apellido;
    private String dni;
    private ArrayList<String> habilidades;

    //Constructor
    public Curriculum(String nombre, String apellido, String dni, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    //Getters y Setters

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    //ToString

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    //Override del metodo imprimir de la interfaz imprimible
    @Override
    public void imprimir(){
        System.out.println("Impresion CV: "+toString());
    }
}
