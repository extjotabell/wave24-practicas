package Products.classes;

public class Perishable extends Products {

    private int daysToCalculate;
    public Perishable(String name, int price, int daysToCalculate) {
        super(name, price);
        this.daysToCalculate = daysToCalculate;
    }

    public int getDaysToCalculate() {
        return daysToCalculate;
    }

    public void setDaysToCalculate(int daysToCalculate) {
        this.daysToCalculate = daysToCalculate;
    }

    @Override
    public int calculateTotal(int quantity){
        int finalPrice = super.calculateTotal(quantity);
        if (this.daysToCalculate == 1 ) {
            finalPrice = finalPrice/4;
        } else if (this.daysToCalculate == 2) {
            finalPrice = finalPrice/3;
        }
        else {
            finalPrice = finalPrice/2;
        }
        return finalPrice;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysToCalculate=" + daysToCalculate +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
