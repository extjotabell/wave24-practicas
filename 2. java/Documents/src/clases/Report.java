package clases;

public class Report extends Document {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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
}

