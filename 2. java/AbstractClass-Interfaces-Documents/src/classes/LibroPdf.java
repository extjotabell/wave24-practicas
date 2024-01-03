package classes;

public class LibroPdf extends Documento{

    private Integer cantPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;
    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    public LibroPdf(Integer cantPaginas, String nombreAutor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPdf{" +
                "cantPaginas=" + cantPaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
