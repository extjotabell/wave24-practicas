package Ejercicio2;

public class Informe implements Imprimible {
    private String autor;
    private String texto;
    private String revisor;
    private Integer paginas;

    public Informe(String autor, String texto, String revisor, Integer paginas) {
        this.autor = autor;
        this.texto = texto;
        this.revisor = revisor;
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Autor: " + this.autor + "\nTexto: " + this.texto + "\nRevisor: " + this.revisor + "\nPaginas: " + this.paginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe...");
        System.out.println(this.toString() + "\n");
    }
}
