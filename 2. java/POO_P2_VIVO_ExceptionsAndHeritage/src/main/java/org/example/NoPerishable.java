package org.example;

public class NoPerishable extends Product{
    private String type;

    @Override
    public String toString() {
        return "NoPerishable{" +
                "type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NoPerishable(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }
}
