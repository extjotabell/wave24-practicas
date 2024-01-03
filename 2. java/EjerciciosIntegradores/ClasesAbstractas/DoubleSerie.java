public class DoubleSerie extends Prototipo <Double> {

    public DoubleSerie(Double index) {
        super(index);
        this.counter = 0D;
    }

    @Override
    public Double getNextValue() {
        return this.counter += this.INDEX;
    }

    @Override
    public void setInitValue(Double value) {
        this.counter = value;
    }
}