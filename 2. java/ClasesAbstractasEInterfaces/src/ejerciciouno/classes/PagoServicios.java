package ejerciciouno.classes;

import ejerciciouno.classes.interfaces.Transaction;

public class PagoServicios implements Transaction {
    @Override
    public Boolean transactionOk() {
        System.out.println("Transaction OK");
        return true;
    }

    @Override
    public Boolean transactionNoOk() {
        System.out.println("Transaction No Ok");
        return true;
    }
}
