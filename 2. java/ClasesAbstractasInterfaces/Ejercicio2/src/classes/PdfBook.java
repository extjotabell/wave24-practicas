package classes;

public class PdfBook extends Document {
    private int numPages;
    private String author;
    private String title;
    private String gender;

    public PdfBook(int numPages, String author, String title, String gender) {
        this.numPages = numPages;
        this.author = author;
        this.title = title;
        this.gender = gender;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void print() {
        System.out.println(
                "Book PDF\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Gender: " + gender + "\n" +
                "Number of pages: " + numPages
        );
    }
}