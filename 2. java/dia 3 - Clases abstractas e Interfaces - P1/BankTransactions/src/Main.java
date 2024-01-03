import classes.*;

public class Main {
    public static void main(String[] args) {

        Basico basico = new Basico();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        Deposito deposito = new Deposito();
        PagoServicios pagoServicios = new PagoServicios();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        Transferencia transferencia = new Transferencia();


        basico.realizarTransaccion(consultaSaldo);
        basico.realizarTransaccion(transferencia);

        cobrador.realizarTransaccion(consultaSaldo);
        cobrador.realizarTransaccion(transferencia);

        ejecutivo.realizarTransaccion(consultaSaldo);
        ejecutivo.realizarTransaccion(transferencia);
    }
}