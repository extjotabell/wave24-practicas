package classes;

import classes.interfaces.Imprimible;

public class LibroPDF implements Imprimible {
    //Atributos como cantidad de paginas, nombre del autor, titulo y genero.
    //Variables
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    //Constructor
    public LibroPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    //Getters y Setters
    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //ToString

    @Override
    public String toString() {
        return "Libro{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    //Implementacion metodo de la interfaz
    @Override
    public void imprimir() {
        System.out.println("Impresion de Libro: " + toString());
    }


}
