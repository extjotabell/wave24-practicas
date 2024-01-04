import java.util.LinkedList;
import java.util.List;

public class CalculoFacturas {
    // Este tipo de dato sera visto en la siguiente clase en vivo
    List<String> mensajeStrings = new LinkedList<>();

    int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
    double totalFactura;
    double precioSeguridadCamara = 1500;
    double precioPatrullaje = 700;

    public void calcularMontoFactura() {
        //Tu codigo aqui
        for (int i = 0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = precioSeguridadCamara;
                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                imprimirMensaje ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = precioSeguridadCamara + precioPatrullaje;
                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                imprimirMensaje("El monto de la factura es de: " + totalFactura);
            }
        }
    }

    private void imprimirMensaje(String mensaje) {
        mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        new CalculoFacturas().calcularMontoFactura();
    }

}
