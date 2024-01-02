public class Perecedero extends Producto {
    private int daysToExpire;

    public Perecedero(int daysToExpire, String name, double price) {
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
    public double calculate(int quantityProducts) {
        switch (this.daysToExpire) {
            case 1:
                return super.calculate(quantityProducts) / 4;
            case 2:
                return super.calculate(quantityProducts) / 3;
            case 3:
                return super.calculate(quantityProducts) / 2;
            default:
                return super.calculate(quantityProducts);
        }
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "daysToExpire=" + daysToExpire +
                '}';
    }
}
