package classes;

public class Item {

    private Integer codigo;
    private String nombre;
    private Integer cantidadComparada;
    private Double costoUnitario;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadComparada() {
        return cantidadComparada;
    }

    public void setCantidadComparada(Integer cantidadComparada) {
        this.cantidadComparada = cantidadComparada;
    }

    public Double getCostounitario() {
        return costoUnitario;
    }

    public void setCostounitario(Double costounitario) {
        this.costoUnitario = costounitario;
    }

    public Item() {

    }

    public Item(Integer codigo, String nombre, Integer cantidadComparada, Double costounitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComparada = cantidadComparada;
        this.costoUnitario = costounitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadComparada=" + cantidadComparada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
