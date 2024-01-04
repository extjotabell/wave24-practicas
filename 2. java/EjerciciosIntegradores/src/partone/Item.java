package partone;

public class Item {
    private String codigo;
    private String nombre;
    private Integer cantidadComprada;
    private Double costoUnitario;

    public Item(String codigo, String nombre, Integer cantidadComprada, Double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = precioUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    @Override
    public String toString() {
        return "Item: " + this.nombre + " - Cantidad: " + this.cantidadComprada + " - Costo Unitario: " + this.costoUnitario;
    }
}
