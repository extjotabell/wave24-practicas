package controller;

import model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaController implements  ICrud<Factura> {

    List<Factura> facturas = new ArrayList<>();

    @Override
    public void mostrar() {
        facturas.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void guardar(Factura obj) {
        facturas.add(obj);
    }

    @Override
    public void eliminar(int id) {
        if(facturas.removeIf(factura -> factura.getCodigoFactura() == id)){
            System.out.println("Factura eliminada");
        }
        else{
            System.out.println("No se encontró factura "+id);
        }
        System.out.println("----------------");
        facturas.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public List mostrarTodos() {
        return facturas;
    }

    @Override
    public Optional buscar(int id) {
        if(facturas.stream().anyMatch(factura -> factura.getCodigoFactura() == id )){

            System.out.println("Factura encontrada");
            return facturas.stream().filter(factura -> factura.getCodigoFactura() == id).findFirst();
        }

        System.out.println();
        return Optional.empty();
    }
}
