public class IntegerSerie extends Prototipo <Integer> {

    public IntegerSerie(Integer index) {
        super(index);
        this.counter = 0;
    }

    @Override
    public Integer getNextValue() {
        return this.counter += this.INDEX;
    }

    @Override
    public void setInitValue(Integer value) {
        this.counter = value;
    }
}