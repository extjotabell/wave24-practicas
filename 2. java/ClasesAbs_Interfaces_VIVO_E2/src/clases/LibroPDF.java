package clases;

import interfaces.Documento;

public class LibroPDF implements Documento {

    private Persona autor;
    private Integer paginas;

    private String titulo;

    private String genero;

    public LibroPDF() {
    }

    public LibroPDF(Persona autor, Integer paginas, String titulo, String genero) {
        this.autor = autor;
        this.paginas = paginas;
        this.titulo = titulo;
        this.genero = genero;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
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

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo LibroPDF, cantidad de pagina " + this.paginas
                + " Autor: " + this.autor.getNombre() + " " + this.autor.getApellido()
                + " Titulo: " + this.titulo + " Genero: " + this.genero);
    }
}
