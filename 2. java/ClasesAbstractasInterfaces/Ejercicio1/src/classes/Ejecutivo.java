package classes;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {
    public Ejecutivo(String firstName, String lastName, String dni) {
        super(firstName, lastName, dni);
    }

    @Override
    public void tipoCliente() {
        System.out.println("Cliente Ejecutivo");
    }

    @Override
    public void depositar() {
        System.out.println("Realizando deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción fallida");
    }

    @Override
    public void tranferir() {
        System.out.println("Realizando transferencia");
    }
}