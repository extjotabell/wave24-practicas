package prints.interfaces;

public abstract class AbstractPrint {
    private String author;

    public AbstractPrint() {}
    public AbstractPrint(String author) {
        this.author = author;
    }

    public abstract String print();

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
