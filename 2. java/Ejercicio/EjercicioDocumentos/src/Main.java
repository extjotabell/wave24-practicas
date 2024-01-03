import classes.BooksPdf;
import classes.Curriculums;
import classes.Reports;
import classes.interfaces.IDocuments;

public class Main {
    public static void main(String[] args) {
        Curriculums curriculums = new Curriculums("John", "Doe", 25, "123456789");
        curriculums.addSkill("Java");
        curriculums.addSkill("JavaScript");
        IDocuments.printDocument(curriculums);
        BooksPdf booksPdf = new BooksPdf(100, "John Doe", "The Last Wish", "Fantasy");
        IDocuments.printDocument(booksPdf);
        Reports reports = new Reports("The Last Wish", 100, "John Doe", "Christian");
        IDocuments.printDocument(reports);
    }
}