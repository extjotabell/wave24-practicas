package ejerciciouno.classes;

import ejerciciouno.classes.interfaces.Transaction;

public class Deposito implements Transaction {
    @Override
    public Boolean transactionOk() {
        System.out.println("Deposito realizado con éxito");
        return true;
    }

    @Override
    public Boolean transactionNoOk() {
        System.out.println("El deposito fallo");
        return true;
    }
}
