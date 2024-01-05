package classes.documentos;

import classes.documentos.interfaces.Imprimible;

public class Informe extends Documento {
    private String texto;
    private Integer cantidadPaginas;
    private Person autor;
    private String revisor;

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor=" + autor +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(Integer cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Person getAutor() {
        return autor;
    }

    public void setAutor(Person autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Informe(String texto, Integer cantidadPaginas, Person autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    @Override
    public void imprimirme() {
        imprimirPerDocument();
        System.out.println(
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor=" + autor +
                ", revisor='" + revisor + '\''
                );

    }
}
