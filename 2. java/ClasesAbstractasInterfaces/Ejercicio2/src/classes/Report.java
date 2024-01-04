package classes;

public class Report extends Document {
    String text;
    int numPages;
    String author;
    String reviewer;

    public Report(String text, int numPages, String author, String reviewer) {
        this.text = text;
        this.numPages = numPages;
        this.author = author;
        this.reviewer = reviewer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public void print() {
        System.out.println(
                "Report\n" +
                "Author: " + author + "\n" +
                "Reviewer: " + reviewer + "\n" +
                "Number of pages: " + numPages + "\n" +
                "Text: " + text
        );
    }
}