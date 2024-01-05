package classes;

public class Reserva {

    private int codigo;
    private String tipo;
    private double valor;

    public Reserva(int codigo, String tipo, double valor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                '}';
    }
}
