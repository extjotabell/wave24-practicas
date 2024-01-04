package factura;

import repositorio.Repositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RepositorioFactura implements Repositorio<Factura> {

    private List<Factura> facturas = new ArrayList<Factura>();

    @Override
    public Optional<Factura> getById(Integer id) {
        return facturas.stream().filter(factura -> factura.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void add(Factura obj) {

    }
}
