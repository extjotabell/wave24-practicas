import classes.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static final void main(String[] args){
        // Crear 3 clientes y guardarlos en una collection
        Cliente cliente1 = new Cliente("123", "nombre1", "apellido1");
        Cliente cliente2 = new Cliente("345", "nombre2", "apellido3");
        Cliente cliente3 = new Cliente("567", "nombre2", "apellido3");

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        // Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        listaClientes.stream()
                .forEach(cliente -> System.out.println(cliente.toString()));

        // Obtener cualquier cliente de la lista y eliminarlo si está presente
        Optional<Cliente> clienteAEliminar = listaClientes.stream().findAny();
        clienteAEliminar.ifPresent(listaClientes::remove);

        //Imprimir si esta presente.
        listaClientes.stream()
                .forEach(cliente -> System.out.println(cliente.toString()));

        //Solicitar por teclado un DNI para buscarlo. Si está en la lista, mostrar sus datos y si no
        //mostrar un mensaje informando la situacion.
        String dniTeclado;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese DNI del cliente a encontrar: ");
        dniTeclado = teclado.next();
        teclado.close();
        var clientesEncontrados = listaClientes.stream()
                .filter(cliente ->cliente.getDni().equals(dniTeclado))
                .toList();

        if (!clientesEncontrados.isEmpty()) {
            System.out.println("Cliente encontrado: " + clientesEncontrados);
        }
        else {
            System.out.println("Cliente con DNI " + dniTeclado + " no encontrado.");
        }
    }
}
