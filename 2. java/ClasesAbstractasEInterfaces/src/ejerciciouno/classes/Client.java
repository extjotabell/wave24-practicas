package ejerciciouno.classes;

import ejerciciouno.classes.interfaces.Transaction;

public abstract class Client {
    public abstract boolean realizarTransaction(Transaction transaction);
}
