package ejercicio2;

public class LibroPDF implements Imprimible {
    private String autor;
    private String titulo;
    private String genero;
    private Integer paginas;

    public LibroPDF(String autor, String titulo, String genero, Integer paginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
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

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Autor: " + this.autor + "\nTitulo: " + this.titulo + "\nGenero: " + this.genero + "\nPaginas: " + this.paginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo libro...");
        System.out.println(this.toString() + "\n");
    }
}
