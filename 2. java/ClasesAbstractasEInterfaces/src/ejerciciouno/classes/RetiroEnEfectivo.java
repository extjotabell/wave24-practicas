package ejerciciouno.classes;

import ejerciciouno.classes.interfaces.Transaction;

public class RetiroEnEfectivo implements Transaction {
    @Override
    public Boolean transactionOk() {
        System.out.println("Retiro en efectivo realizado con éxito");
        return true;
    }

    @Override
    public Boolean transactionNoOk() {
        System.out.println("Reetiro en efectivo fallo");
        return true;
    }
}
