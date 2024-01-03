import prints.Printer;
import prints.Report;

public class App {
    public static void main(String[] args) throws Exception {
        Printer printer = new Printer(new Report("Camilo"));
        System.out.println(printer.print());
    }
}
