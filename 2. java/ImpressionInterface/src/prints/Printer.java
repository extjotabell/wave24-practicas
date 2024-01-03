package prints;

import prints.interfaces.AbstractPrint;

public class Printer {
    private AbstractPrint paper;
    
    public Printer() {}
    public Printer(AbstractPrint paper) {
        this.paper = paper;
    }

    public String print() {
        if (paper == null) {
            return "Nothing to print.";
        } 

        return paper.print();
    }

    public AbstractPrint getPaper() {
        return paper;
    }
    public void setPaper(AbstractPrint paper) {
        this.paper = paper;
    }
}
