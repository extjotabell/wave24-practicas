package classes;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {
    @Override
    public void depositar() {
        System.out.println("Depositando.");
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transacción se hizo correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no se hizo correctamente.");
    }

    @Override
    public void transferir() {
        System.out.println("Transfiriendo.");
    }
}
