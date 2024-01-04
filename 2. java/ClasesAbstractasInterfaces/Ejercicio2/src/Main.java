import classes.*;
import interfaces.Printable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Resume resume = new Resume("Marcos", "Anzurez", Arrays.asList("MySQL", "Java"));
        Printable.printDocument(resume);

        PdfBook pdfBook = new PdfBook(120, "Robert J.", "Book", "Fantasy");
        Printable.printDocument(pdfBook);

        Report report = new Report("Text Report", 6, "Rob R.", "Sara H.");
        Printable.printDocument(report);
    }
}