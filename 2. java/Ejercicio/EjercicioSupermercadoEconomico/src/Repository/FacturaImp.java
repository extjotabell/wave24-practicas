package Repository;

import classes.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements ICrud<Factura> {
    List<Factura> facturas = new ArrayList<>();
    @Override
    public void mostrar() {
        System.out.println("--- Mostrar Facturas ---");
        facturas.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void guardar(Factura obj) {
        facturas.add(obj);
    }

    @Override
    public void eliminar(Long codigoFactura) {
        if(facturas.removeIf(factura -> factura.getNumeroFactura().equals(codigoFactura))){
            System.out.println("Factura eliminada");
        }
        else{
            System.out.println("No se encontro la factura");
        }
        System.out.println();
        facturas.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public List<Factura> consultarTodos() {
        return facturas;
    }

    @Override
    public Optional<Factura> buscar(Long codigoFactura) {
        if(facturas.stream().anyMatch(factura -> factura.getNumeroFactura().equals(codigoFactura))){
            System.out.println("Factura encontrada");
            return facturas.stream().filter(factura -> factura.getNumeroFactura().equals(codigoFactura)).findFirst();
        }
        else{
            System.out.println("No se encontró factura");
        }
        System.out.println();
        return Optional.empty();
    }
}
