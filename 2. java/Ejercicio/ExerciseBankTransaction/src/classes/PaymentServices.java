package classes;

import classes.interfaces.Transaction;

public class PaymentServices implements Transaction {

    @Override
    public boolean transactionOk() {
        System.out.println("Se está ejecutando una pago de servicios");
        return false;
    }
    @Override
    public boolean transactionNotOk() {
        System.out.println("El pago de servicios falló");
        return false;
    }
}
