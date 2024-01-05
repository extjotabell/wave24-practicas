package classes;

import interfaces.ConsultaSaldo;
import interfaces.RetiroEfectivo;

public class Cobrador extends Cliente implements RetiroEfectivo, ConsultaSaldo {
    public Cobrador(String firstName, String lastName, String dni) {
        super(firstName, lastName, dni);
    }

    @Override
    public void tipoCliente() {
        System.out.println("Cliente Cobrador");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Realizando consulta de saldo");
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