package org.example;

public class Perishable extends Product {
    private int daysToExpire;

    public int getDaysToExpire() {
        return daysToExpire;
    }


    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculate(int amountOfProducts){
        double price=(amountOfProducts*this.getPrice());
        if(this.daysToExpire==1){
            price=price/4;
        } else if (this.daysToExpire==2) {
            price=price/3;
        } else if (this.daysToExpire==3) {
            price=price/2;
        }
        return price;
    }
    @Override
    public String toString() {
        return "Perishable{" +
                "daysToExpire=" + daysToExpire +
                '}';
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }
}
