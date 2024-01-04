import cliente.Cliente;
import cliente.RepositorioCliente;
import factura.Factura;
import factura.ServicioFactura;
import item.Item;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        RepositorioCliente repositorioCliente = new RepositorioCliente();

        List<Item> items = Arrays.asList(
                new Item(1, "123", "Agua", 2, 300.0),
                new Item(2, "234", "Leche", 4, 700.0),
                new Item(3, "345", "Manteca", 1, 500.0),
                new Item(4, "456", "Harina", 2, 350.0)
        );

        Factura facturaSinItems = new Factura(1, repositorioCliente.getClientes().get(0), new ArrayList<>());

        Factura facturaNormal = new Factura(2, repositorioCliente.getClientes().get(1), items);

        ServicioFactura servicioFactura = new ServicioFactura();

        servicioFactura.agregarFactura(facturaNormal);

    }
}