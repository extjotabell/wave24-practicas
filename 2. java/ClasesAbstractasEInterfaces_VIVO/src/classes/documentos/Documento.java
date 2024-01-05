package classes.documentos;

import classes.documentos.interfaces.Imprimible;

public abstract class Documento implements Imprimible {
    public abstract void imprimirme();
    @Override
    public void imprimirPerDocument() {
        System.out.println(getClass().getSimpleName().toUpperCase() );
    }
}
