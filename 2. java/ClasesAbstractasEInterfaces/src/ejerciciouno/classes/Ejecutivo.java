package ejerciciouno.classes;

import ejerciciouno.classes.interfaces.Transaction;

public class Ejecutivo extends Client{
    @Override
    public boolean realizarTransaction(Transaction transaction) {
        if(!(transaction instanceof Deposito) && !(transaction instanceof Transferencia)){
            return transaction.transactionNoOk();
        }
        return transaction.transactionOk();
    }
}
