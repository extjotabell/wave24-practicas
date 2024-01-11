package view;

import controller.FacturaController;

import java.util.Scanner;

public class FacturaView {

    private FacturaController facturaController;

    public FacturaView(FacturaController facturaController) {
        this.facturaController = facturaController;
        generarMenu();
    }

    private void generarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println(">>MENU Facturas<<");
            System.out.println("1. Crear factura");
            System.out.println("2. Mostrar factura");
            System.out.println("3. Buscar por codigo ");
            System.out.println("4. Eliminar factura por codigo");
            System.out.println("5. Salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println(">>CREANDO FACTURA<<");

                    break;
                case 2:
                    System.out.println(">>MOSTRAR FACTURA<<");
                    facturaController.mostrar();
                    break;
                case 3:
                    System.out.println(">>BUSCAR FACTURA<<");
                    System.out.println("Ingrese codigo: ");
                    int codigoBuscado = sc.nextInt();
                    var facturaBuscada = facturaController.buscar(codigoBuscado).orElse(null);
                    System.out.println(facturaBuscada);
                    break;
                case 4:
                    System.out.println(">>ELIMINAR FACTURA<<");
                    System.out.println("Ingrese codigo: ");
                    int codigoParaEliminar = sc.nextInt();
                    facturaController.eliminar(codigoParaEliminar);
            }

        } while (opcion !=5);
    }
}
