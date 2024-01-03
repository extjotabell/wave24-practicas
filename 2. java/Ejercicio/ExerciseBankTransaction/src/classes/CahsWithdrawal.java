package classes;

import classes.interfaces.Transaction;

public class CahsWithdrawal implements Transaction {

    @Override
    public boolean transactionOk() {
        System.out.println("Se está ejecutando un retiro de efectivo");
        return false;
    }
    @Override
    public boolean transactionNotOk() {
        System.out.println("El retiro de efectivo falló");
        return false;
    }
}
