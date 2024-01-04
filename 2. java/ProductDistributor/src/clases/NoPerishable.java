package clases;

public class NoPerishable extends Product{
    private String type="";

    public NoPerishable(String name, double price, String type) {
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
    public String toString() {
        return "No Perecedero{" +
                "tipo:'" + type + '\'' +
                "nombre: " + this.getName() +
                "precio: " + this.getPrice() +
                '}';
    }
    @Override
    public double calculate(int quantity) {
        return 0;
    }
}
