public class NoPerecedero extends Producto {
    private String type;

    public NoPerecedero(String type, String name, double price) {
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
    public double calculate(int quantityProducts) {
        return super.calculate(quantityProducts);
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "type='" + type + '\'' +
                '}';
    }
}
