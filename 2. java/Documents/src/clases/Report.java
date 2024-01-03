package clases;

public class Report extends Document{
    String text;
    int pageCount;
    String author;
    String reviewer;

    public Report(String text, int pageCount, String author, String reviewer) {
        this.text = text;
        this.pageCount = pageCount;
        this.author = author;
        this.reviewer = reviewer;
    }
    @Override
    public void showContent() {
        System.out.println("Report");
        System.out.println("Author: " + author);
        System.out.println("Reviewer: " + reviewer);
        System.out.println("Number of pages: " + pageCount);
        System.out.println("Text: " + text);
    }
}
