package prints;

import prints.interfaces.AbstractPrint;

public class PDF extends AbstractPrint {
    private Integer totalPages;
    private String title;
    private String genre;

    public PDF(String author) {
        super(author);
        this.totalPages = 0;
        this.title = "";
        this.genre = "";
    }
    public PDF(Integer totalPages, String author, String title, String genre) {
        super(author);
        this.totalPages = totalPages;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String print() {
        return "PDF\n\nAuthor: " + this.getAuthor() 
            + "\n\nTitle: " + title 
            + "\n\nGenre: " + genre 
            + "\n\nTotal Pages: " + totalPages;
    }

    public Integer getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
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
