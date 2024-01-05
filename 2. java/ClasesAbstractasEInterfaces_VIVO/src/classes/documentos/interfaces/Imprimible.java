package classes.documentos.interfaces;

import classes.documentos.Documento;

public interface Imprimible {
    static  void imprimirDocumento (Documento documento){
        documento.imprimirme();
    }
    void imprimirPerDocument();
}
