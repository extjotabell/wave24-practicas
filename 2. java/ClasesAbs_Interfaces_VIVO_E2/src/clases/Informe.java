package clases;

import interfaces.Documento;
import org.w3c.dom.Text;

public class Informe implements Documento {

    private Persona autor;
    private Integer paginas;
    private Persona revisor;
    private String texto;

    public Informe(Persona autor, Persona revisor, String texto, Integer paginas) {
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
        this.paginas = paginas;
    }

    public Informe() {
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Informe, cantidad de pagina " + this.paginas
        + " Autor: " + this.autor.getNombre() + " " + this.autor.getApellido()
        + " Revisor: " + this.revisor.getNombre() + " " + this.revisor.getApellido()
        + " Texto: " + this.texto
        );
    }
}
