package prints;

import prints.interfaces.AbstractPrint;

public class Report extends AbstractPrint {
    private String description;
    private Integer totalPages;
    private String reviewer;

    public Report(String author) {
        super(author);
        this.description = "";
        this.totalPages = 0;
        this.reviewer = "";
    }
    public Report(String author, String description, Integer totalPages, String reviewer) {
        super(author);
        this.description = description;
        this.totalPages = totalPages;
        this.reviewer = reviewer;
    }

    @Override
    public String print() {
        return "Report\n\nAuthor: " + this.getAuthor() 
            + "\n\nDescription: " + description 
            + "\n\nTotal Pages: " + totalPages 
            + "\n\nReviewer: " + reviewer;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
    public String getReviewer() {
        return reviewer;
    }
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}
