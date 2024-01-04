package ejerciciouno.classes;

import ejerciciouno.classes.interfaces.Transaction;

public class ConsultaSaldo implements Transaction {
    @Override
    public Boolean transactionOk() {
        System.out.println("Consulta de salgo OK");
        return true;
    }

    @Override
    public Boolean transactionNoOk() {
        System.out.println("Consulta de salgo fallo");
        return true;
    }
}
