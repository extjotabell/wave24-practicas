package classes;

import interfaces.ConsultaSaldo;
import interfaces.PagoServicio;
import interfaces.RetiroEfectivo;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    public Basic(String firstName, String lastName, String dni) {
        super(firstName, lastName, dni);
    }

    @Override
    public void tipoCliente() {
        System.out.println("Cliente Basic");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Realizando consulta de saldo");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Realizando pago de servicio");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Realizando retiro de efectivo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción fallida");
    }
}