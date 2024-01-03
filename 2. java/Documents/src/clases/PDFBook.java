package clases;

public class PDFBook extends Document{
    int pageCount;
    String authorName;
    String title;
    String genre;
    public PDFBook(int pageCount, String authorName, String title, String genre) {
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.title = title;
        this.genre = genre;
    }
    @Override
    public void showContent() {
        System.out.println("PDF Book - " + title);
        System.out.println("Author: " + authorName);
        System.out.println("Genre: " + genre);
        System.out.println("Number of pages: " + pageCount);
    }
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
