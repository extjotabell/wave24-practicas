package interfaces;

import classes.Document;

public interface Printable {
    public static void printDocument(Document document) {
        document.print();
    }
}