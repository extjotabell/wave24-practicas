package ejerciciouno.classes;

import ejerciciouno.classes.interfaces.Transaction;

public class Transferencia implements Transaction {
    @Override
    public Boolean transactionOk() {
        System.out.println("Transferencia ok");
        return true;
    }

    @Override
    public Boolean transactionNoOk() {
        System.out.println("Transferencia fallida");
        return true;
    }
}
