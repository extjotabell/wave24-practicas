package classes;

import classes.interfaces.IDocuments;

public class BooksPdf extends Document {
    private int quantityPages;
    private String nameAuthor;
    private String title;
    private String gender;

    public BooksPdf(int quantityPages, String nameAuthor, String title, String gender) {
        this.quantityPages = quantityPages;
        this.nameAuthor = nameAuthor;
        this.title = title;
        this.gender = gender;
    }

    public int getQuantityPages() {
        return quantityPages;
    }

    public void setQuantityPages(int quantityPages) {
        this.quantityPages = quantityPages;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
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
    public String toString() {
        return "BooksPdf{" +
                "quantityPages=" + quantityPages +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public void print() {
        printTypeDoc();
        System.out.println("Quantity pages: " + quantityPages);
        System.out.println("Name author: " + nameAuthor);
        System.out.println("Title: " + title);
        System.out.println("Gender: " + gender);
    }
}
