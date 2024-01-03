import clases.Curriculum;
import clases.PDFBook;
import clases.Report;
import interfaces.Printable;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Diego", "Pachon","89686756", "Java, Teamwork");
        PDFBook pdfBook = new PDFBook(370, "Andrea Torres", "Corriendo riesgos", "Autoayuda");
        Report report = new Report("Reporte de accidentes", 29, "Diego P.", "Revisa Danien P,");

        Printable.print(curriculum);
        Printable.print(pdfBook);
        Printable.print(report);

    }
}