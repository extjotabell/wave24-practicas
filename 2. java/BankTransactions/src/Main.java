import clases.*;

public class Main {
    public static void main(String[] args) {

        // Cliente Ejecutivo realizando un depósito
        Cliente ejecutivo = new Ejecutivo();
        ejecutivo.realizarTransaccion(new Deposito());

        // Cliente Basic realizando un retiro de efectivo
        Cliente basico = new Basico();
        basico.realizarTransaccion(new RetiroEfectivo());

        //Cliente Cobrador realizando una transferencia que no es permitido
        Cliente cobrador = new Cobrador();
        cobrador.realizarTransaccion(new Transferencia());
    }
}