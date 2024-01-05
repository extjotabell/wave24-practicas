package clases;

public class BaseReservation {
    String type;
    double price;

    public BaseReservation(String type, double price) {
        this.type = type;
        this.price = price;
    }
    @Override
    public String toString() {
        return "BaseReservation{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
    public void applyDiscounts(){

    }
}
