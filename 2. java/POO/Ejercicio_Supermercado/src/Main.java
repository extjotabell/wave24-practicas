import classes.Cliente;
import classes.Factura;
import classes.Item;
import repositories.ClienteRepositorio;
import repositories.FacturaRepositorio;
import repositories.ItemRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
    private static ItemRepositorio itemRepositorio = new ItemRepositorio();
    private static FacturaRepositorio facturaRepositorio = new FacturaRepositorio(clienteRepositorio, itemRepositorio);
    public static void main(String[] args) {
        boolean salir = false;

        while (!salir){
            System.out.println("1. CRUD CLIENTES");

            System.out.println("2. CRUD FACTURAS");

            System.out.println("3. CRUD ITEMS");

            System.out.println("4. Salir");

            System.out.println("Introduce una opción: ");

            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    boolean salirCRUDClientes = false;

                    while (!salirCRUDClientes){

                        System.out.println("1. Agregar cliente");

                        System.out.println("2. Listar clientes");

                        System.out.println("3. Editar cliente");

                        System.out.println("4. Eliminar cliente");

                        System.out.println("5. Salir");

                        System.out.println("Introduce una opción: ");

                        int opcionCRUDClientes = sc.nextInt();



                        switch (opcionCRUDClientes){
                            case 1:
                                System.out.println("Ingrese nombre del cliente");
                                String nombre = sc.nextLine();
                                System.out.println("Ingrese apellido del cliente");
                                String apellido = sc.nextLine();
                                System.out.println("Ingrese dni del cliente");
                                int dni = sc.nextInt();
                                Cliente clienteNuevo = new Cliente(nombre, apellido, dni);
                                clienteRepositorio.agregar(clienteNuevo);
                                break;
                            case 2:
                                List<Cliente> clientes = clienteRepositorio.listar();
                                clientes.forEach(System.out::println);
                                break;
                            case 3:
                                System.out.println("Ingrese dni del cliente a editar");
                                int dniEditar = sc.nextInt();
                                System.out.println("Ingrese nombre del cliente");
                                String nombreEditar = sc.nextLine();
                                System.out.println("Ingrese apellido del cliente");
                                String apellidoEditar = sc.nextLine();
                                Cliente clienteEditar = new Cliente(nombreEditar, apellidoEditar, dniEditar);
                                clienteRepositorio.editar(dniEditar, clienteEditar);
                                break;
                            case 4:
                                System.out.println("Ingrese dni del cliente a eliminar");
                                int dniEliminar = sc.nextInt();
                                clienteRepositorio.eliminar(dniEliminar);
                                break;
                            case 5:
                                salirCRUDClientes = true;
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean salirCRUDFacturas = false;

                    while (!salirCRUDFacturas){

                        System.out.println("1. Agregar factura");

                        System.out.println("2. Listar facturas");

                        System.out.println("3. Salir");

                        int opcionCRUDFacturas = sc.nextInt();
                        switch (opcionCRUDFacturas){
                            case 1:
                                System.out.println("Ingrese dni del cliente");
                                int dni = sc.nextInt();
                                Cliente clienteFactura = clienteRepositorio.listar().stream().filter(c -> c.getDni() == dni).findFirst().orElse(null);
                                if(clienteFactura == null){
                                    System.out.println("El cliente no existe");
                                    System.out.println("Ingrese nombre del cliente");
                                    String nombre = sc.nextLine();
                                    System.out.println("Ingrese apellido del cliente");
                                    String apellido = sc.nextLine();
                                    clienteFactura = new Cliente(nombre, apellido, dni);
                                }

                                //TODO agregar items factura

                                Factura facturaNueva = new Factura(clienteFactura, new ArrayList<>());
                                facturaRepositorio.agregar(facturaNueva);
                                break;
                            case 2:
                                List<Factura> facturas = facturaRepositorio.listar();
                                facturas.forEach(System.out::println);
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }


                    }

                    break;
                case 3:
                    boolean salirCrudItems = false;

                    while (!salirCrudItems){

                        System.out.println("1. Agregar item");

                        System.out.println("2. Listar items");

                        System.out.println("3. Editar item");

                        System.out.println("4. Eliminar item");

                        System.out.println("5. Salir");

                        int opcionCRUDItem = sc.nextInt();
                        switch (opcionCRUDItem){
                            case 1:
                                System.out.println("Ingrese nombre del item");
                                String nombre = sc.nextLine();
                                System.out.println("Ingrese codigo del item");
                                String codigo = sc.nextLine();
                                System.out.println("Ingrese cantidad del item");
                                int cantidad = sc.nextInt();
                                System.out.println("Ingrese precio unitario del item");
                                double precioUnitario = sc.nextDouble();
                                Item itemNuevo = new Item(nombre, codigo, cantidad, precioUnitario);
                                itemRepositorio.agregar(itemNuevo);
                                break;
                            case 2:
                                List<Item> items = itemRepositorio.listar();
                                items.forEach(System.out::println);
                                break;
                            case 3:
                                System.out.println("Ingrese id del item a editar");
                                int idEditar = sc.nextInt();
                                System.out.println("Ingrese nombre del item");
                                String nombreEditar = sc.nextLine();
                                System.out.println("Ingrese codigo del item");
                                String codigoEditar = sc.nextLine();
                                System.out.println("Ingrese cantidad del item");
                                int cantidadEditar = sc.nextInt();
                                System.out.println("Ingrese precio unitario del item");
                                double precioUnitarioEditar = sc.nextDouble();
                                Item itemEditar = new Item(nombreEditar, codigoEditar, cantidadEditar, precioUnitarioEditar);
                                itemRepositorio.editar(idEditar, itemEditar);
                                break;
                            case 4:
                                System.out.println("Ingrese id del item a eliminar");
                                int idEliminar = sc.nextInt();
                                itemRepositorio.eliminar(idEliminar);
                                break;
                            case 5:
                                salirCrudItems = true;
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

    }
}