package products;

public class NoPerishable extends Product {
    private String type;

    public NoPerishable() {}
    public NoPerishable(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
