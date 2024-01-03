package interfaces;

import classes.Documento;

public interface Imprimible {
    static void imprimirDocumento(Documento documento){
        documento.imprimir();
    }
}
