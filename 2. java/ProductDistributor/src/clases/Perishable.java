package clases;

public class Perishable extends Product{
    private int daysToExpire = 0;
    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }
    @Override
    public double calculate(int quantity){
        double amount = this.getPrice() * quantity;
        switch (daysToExpire){
            case 1:
                return amount/4;
            case 2:
                return amount/3;
            case 3:
                return amount/2;
        }
        return amount;
    }
    @Override
    public String toString() {
        return "Perecedero{" +
                "dias Por Caducar: " + daysToExpire +
                " nombre: " + this.getName() +
                " precio: " + this.getPrice() +
                '}';
    }
}
