package org.example;

import java.util.ArrayList;

public class Distributor {
    public static void main(String[] args) {
        ArrayList<Product> listOfProducts=new ArrayList<Product>();
        listOfProducts.add(new Perishable("tomato",1000,3));
        listOfProducts.add(new Perishable("apple",3000,1));
        listOfProducts.add(new Perishable("milk",2000,3));
        listOfProducts.add(new Perishable("rice",1200,2));
        listOfProducts.add(new Perishable("onion",1050,1));

        listOfProducts.add(new NoPerishable("headphone",10000,"peripherals"));
        listOfProducts.add(new NoPerishable("ram 16 Gb",13000,"hardware"));
        listOfProducts.add(new NoPerishable("GeForce Rtx",15000,"hardware"));
        listOfProducts.add(new NoPerishable("KeyChron k5",35000,"peripherals"));
        listOfProducts.add(new NoPerishable("Re dragon k942",150000,"peripherals"));
        double perishableTotal=0;
        double noPerishableTotal=0;
        double generalTotal=0;
        for (Product product :listOfProducts){
            if(product instanceof Perishable){
                double value=product.calculate(5);
                perishableTotal+=value;
                generalTotal+=value;
            } else if (product instanceof NoPerishable) {
                double value=product.calculate(5);
                noPerishableTotal+=value;
                generalTotal+=value;
            }
        }
        System.out.println("The total price of the perishable products is:" + String.valueOf(perishableTotal));
        System.out.println("The total price of the no perishable products is:" + String.valueOf(noPerishableTotal));
        System.out.println("The total price is:" + String.valueOf(generalTotal));

    }

}
