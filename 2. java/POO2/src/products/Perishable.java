package products;

public class Perishable extends Product {
    private int expireDays;

    public Perishable() {
        this.expireDays = 0;
    }
    public Perishable(int expireDays) {
        this.expireDays = expireDays;
    }

    @Override
    public double calculate() {
        int reductionTimes;

        switch (expireDays) {
            case 1:
                reductionTimes = 4;
                break;
        
            case 2: 
                reductionTimes = 3;
                break;

            case 3:
                reductionTimes = 2;
                break;

            default:
                reductionTimes = 1;
        }

        return super.calculate()/reductionTimes;
    }

    public int getExpireDays() {
        return expireDays;
    }
    public void setExpireDays(int expireDays) {
        this.expireDays = expireDays;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "expireDays=" + expireDays +
                '}';
    }
}
