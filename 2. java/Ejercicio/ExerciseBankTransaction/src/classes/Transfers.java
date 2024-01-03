package classes;

import classes.interfaces.Transaction;

public class Transfers implements Transaction {

    @Override
    public boolean transactionOk() {
        System.out.println("Se está ejecutando una transferencia");
        return false;
    }
    @Override
    public boolean transactionNotOk() {
        System.out.println("La transferencia falló");
        return false;
    }
}
