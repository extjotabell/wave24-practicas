package factura;

import cliente.Cliente;
import cliente.RepositorioCliente;
import item.Item;

import java.lang.ref.Cleaner;
import java.util.Optional;
import java.util.Scanner;

public class ServicioFactura {

    private final RepositorioCliente repositorioCliente;
    private final RepositorioFactura repositorioFactura;

    public ServicioFactura() {
        this.repositorioCliente = new RepositorioCliente();
        this.repositorioFactura = new RepositorioFactura();
    }

    public void agregarFactura(Factura factura) {
        Optional<Cliente> cliente = repositorioCliente.getById(factura.getCliente().getId());

        if(factura.getItems() == null || factura.getItems().isEmpty()){
            System.out.println("Se debe agregar una lista de items");
            return;
        }

        factura.setTotalCompra(
                factura.getItems()
                        .stream()
                        .mapToDouble(item -> item.getCostoUnitario()*item.getCantidadComprada())
                        .sum()
        );

        if (cliente.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Antes de cargar la factura debe cargar el cliente");
            System.out.println("ID: ");
            Integer id = scanner.nextInt();
            System.out.println("DNI: ");
            String dni = scanner.nextLine();
            System.out.println("NOMBRE: ");
            String nombre = scanner.nextLine();
            System.out.println("APELLIDO: ");
            String apellido = scanner.nextLine();

            Cliente clienteACargar = new Cliente(id, dni, nombre, apellido);
            repositorioCliente.add(clienteACargar);

        }

        repositorioFactura.add(factura);
        System.out.println("Se agrego la factura: " + factura.toString());
    }

}
