package agenciadeviajes;

public class Reserva {
    public final static String TIPO_HOTEL = "Hotel";
    public final static String TIPO_COMIDA = "Comida";
    public final static String TIPO_VIAJE = "Viaje";
    public final static String TIPO_TRANSPORTE = "Transporte";

    private Integer codigo;
    private String tipo;
    private Double precio;

    public Reserva(Integer codigo, String tipo, Double precio) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Reserva: " + this.codigo + " - Tipo: " + this.tipo + " - Precio: " + this.precio;
    }
}
