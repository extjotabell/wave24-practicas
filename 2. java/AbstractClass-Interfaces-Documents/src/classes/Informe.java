package classes;

public class Informe extends Documento{
    private String texto;
    private Integer cantPaginas;
    private String autor;
    private String revisor;
    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    public Informe(String texto, Integer cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
