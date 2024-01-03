package interfaces;

import clases.Document;

public interface Printable {
    static void print(Document document) {
        System.out.println("Imprimiendo documento...");
        document.showContent();
    }
}
