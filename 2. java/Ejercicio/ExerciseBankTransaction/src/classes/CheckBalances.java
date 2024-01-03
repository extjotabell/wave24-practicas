package classes;

import classes.interfaces.Transaction;

public class CheckBalances implements Transaction {

    @Override
    public boolean transactionOk() {
        System.out.println("Se está ejecutando una consulta de saldo");
        return false;
    }
    @Override
    public boolean transactionNotOk() {
        System.out.println("La consulta de saldo falló");
        return false;
    }
}
