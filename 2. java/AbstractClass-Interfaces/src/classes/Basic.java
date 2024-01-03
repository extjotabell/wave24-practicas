package classes;

import interfaces.ConsultaSaldo;
import interfaces.PagoServicios;
import interfaces.RetiroEfectivo;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo.");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Pagando sevicios.");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo,");
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transacción se hizo correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no se hizo correctamente.");
    }
}
