package products;

public class Product {
    private String name;
    private double price;
    private int productQuantity;

    public Product() {
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Product(String name, double price, int productQuantity) {
        this.name = name;
        this.price = price;
        this.productQuantity = productQuantity;
    }

    public double calculate() {
        return productQuantity * price;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productNumber) {
        this.productQuantity = productNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
