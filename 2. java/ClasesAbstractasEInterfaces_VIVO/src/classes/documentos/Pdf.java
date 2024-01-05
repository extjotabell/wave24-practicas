package classes.documentos;

import classes.documentos.interfaces.Imprimible;

public class Pdf extends Documento {
    private int cantidadPaginas;
    private Person autor;
    private String titulo;
    private String genero;

    @Override
    public String toString() {
        return "Pdf{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor=" + autor +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Person getAutor() {
        return autor;
    }

    public void setAutor(Person autor) {
        this.autor = autor;
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

    public Pdf(int cantidadPaginas, Person autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimirme() {
        imprimirPerDocument();
        System.out.println(
                "cantidadPaginas=" + cantidadPaginas +
                ", autor=" + autor +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' );

    }


}
