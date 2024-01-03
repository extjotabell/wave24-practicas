package classes.interfaces;

import classes.Document;

public interface IDocuments {
    static void printDocument(Document document) {
        document.print();
    };
    void printTypeDoc();
}
