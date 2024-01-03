package classes;

import classes.interfaces.IDocuments;

public abstract class Document implements IDocuments {
    public abstract void print();
    @Override
    public void printTypeDoc() {
        System.out.println(getClass().getSimpleName().toUpperCase());
    }
}
