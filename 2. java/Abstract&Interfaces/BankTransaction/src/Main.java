import Classes.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Basico basico = new Basico();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        ConsultarSaldo consultaSaldo = new ConsultarSaldo();
        Deposito deposito = new Deposito();
        PagoServicios pagoServicio = new PagoServicios();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        Transferencia transferencia = new Transferencia();

        basico.realizarTransaccion(consultaSaldo);
        basico.realizarTransaccion(deposito);

        cobrador.realizarTransaccion(pagoServicio);
        cobrador.realizarTransaccion(transferencia);

        ejecutivo.realizarTransaccion(transferencia);
        ejecutivo.realizarTransaccion(retiroEfectivo);

    }
}