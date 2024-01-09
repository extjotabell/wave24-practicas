package Variables;

import java.util.Scanner;

public class DetalleDeFactura {


 //
 //Calcule el total, sume ambos precios y agregue un valor de impuesto del 19%
 //
 //Se pide mostrar en un solo String el nombre de la factura, el monto total bruto (antes de impuesto), el impuesto y el monto total neto incluyendo impuesto.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la factura");
        String nombreFactura = s.nextLine();
        System.out.println("ingrese el valor de producto 1");
        double precio1 = s.nextDouble();
        System.out.println("ingrese el valor de producto 2");
        double precio2 = s.nextDouble();

        double total = precio1 + precio2;
        double impuesto = total * 0.19;
        double totalNeto = total + impuesto;
        System.out.println("El total de la factura" + nombreFactura + " es " + total);

    }
}
