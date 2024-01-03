package classes;

import classes.interfaces.Transaction;

public class Deposit implements Transaction {

    @Override
    public boolean transactionOk() {
        System.out.println("Se está ejecutando un deposito");
        return false;
    }
    @Override
    public boolean transactionNotOk() {
        System.out.println("El deposito de saldo falló");
        return false;
    }
}
