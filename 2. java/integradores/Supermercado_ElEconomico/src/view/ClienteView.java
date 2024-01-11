package view;
import controller.ClienteController;
import java.util.Scanner;
import model.Cliente;


public class ClienteView {

    private ClienteController clienteController;

    public ClienteView(ClienteController clienteController) {
        this.clienteController = clienteController;
        generarMenu();
    }

    public void generarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(">>MENU Clientes<<");
            System.out.println("1. Crear clientes");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Buscar por DNI ");
            System.out.println("4. Eliminar cliente por DNI");
            System.out.println("5. Salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println(">>CREANDO CLIENTES<<");

                    Cliente cliente1 = new Cliente(1234, "Juan", "Perez");
                    Cliente cliente2 = new Cliente(5678, "Carlos", "Suarez");
                    Cliente cliente3 = new Cliente(10987, "Maria", "Rodriguez");

                    clienteController.guardar(cliente1);
                    clienteController.guardar(cliente2);
                    clienteController.guardar(cliente3);

                    break;
                case 2:
                    System.out.println(">>MOSTRAR CLIENTE<<");
                    clienteController.mostrar();
                    break;
                case 3:
                    System.out.println(">>BUSCAR CLIENTE<<");
                    System.out.println("Ingrese DNI: ");
                    int dniBuscado = sc.nextInt();
                    var clienteBuscado = clienteController.buscar(dniBuscado).orElse(null);
                    System.out.println(clienteBuscado);
                    break;
                case 4:
                    System.out.println(">>ELIMINAR CLIENTE<<");
                    System.out.println("Ingrese DNI: ");
                    int dniParaEliminar = sc.nextInt();
                    clienteController.eliminar(dniParaEliminar);

                    break;
            }

        }while (opcion !=5);
    }
}
