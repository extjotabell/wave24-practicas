package classes;

public class Reports  extends Document{
    private String text;
    private int QuantityPages;
    private String author;
    private String revewer;

    public Reports(String text, int quantityPages, String author, String revewer) {
        this.text = text;
        QuantityPages = quantityPages;
        this.author = author;
        this.revewer = revewer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getQuantityPages() {
        return QuantityPages;
    }

    public void setQuantityPages(int quantityPages) {
        QuantityPages = quantityPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRevewer() {
        return revewer;
    }

    public void setRevewer(String revewer) {
        this.revewer = revewer;
    }

    @Override
    public void print() {
        printTypeDoc();
        System.out.println("Text: " + text);
        System.out.println("Quantity pages: " + QuantityPages);
        System.out.println("Author: " + author);
        System.out.println("Revewer: " + revewer);
    }
}
