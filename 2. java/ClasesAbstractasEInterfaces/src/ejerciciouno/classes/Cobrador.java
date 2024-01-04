package ejerciciouno.classes;

import ejerciciouno.classes.interfaces.Transaction;

public class Cobrador extends Client {

    @Override
    public boolean realizarTransaction(Transaction transaction) {
        if(!(transaction instanceof RetiroEnEfectivo) && !(transaction instanceof ConsultaSaldo)){
            return transaction.transactionNoOk();
        }
        return transaction.transactionOk();
    }
}
