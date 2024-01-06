package Products.classes;

public class Noperishable extends Products{
    String type;

    public Noperishable(String name, int price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int calculateTotal(int quantity){
        return super.calculateTotal(quantity);
    }

    @Override
    public String toString() {
        return "Noperishable{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
