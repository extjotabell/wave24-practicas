package classes;

import interfaces.Crud;

import java.util.List;

public class Item implements Crud<Item> {
    private Long codigo;
    private String nombre;
    private Integer cantidadComprada;
    private Double costoUnitario;
    private List<Item> listItems;

    public Item(Long codigo, String nombre, Integer cantidadComprada, Double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }


    @Override
    public void save(Item obj) {
        listItems.add(obj);
    }

    @Override
    public void delete(Item obj) {
        listItems.remove(obj);
    }

    @Override
    public void modify(Item obj) {
        this.listItems.add(getIndex(obj.getCodigo()),obj);
    }

    @Override
    public List<Item> list() {
        return this.listItems;
    }

    public int getIndex(Long codigo){
        Item item = this.listItems.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst().get();
        return this.listItems.indexOf(item);
    }
}
