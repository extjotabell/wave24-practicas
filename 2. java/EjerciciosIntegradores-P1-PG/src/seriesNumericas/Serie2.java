package seriesNumericas;

public class Serie2 extends Prototype{

    int initialValue;
    int currentValue;
    int nextValue;

    public Serie2(int initialValue) {
        this.initialValue = initialValue;
        this.currentValue = initialValue;
    }

    @Override
    public Object getNextValue() {
        this.currentValue = this.nextValue;
        this.nextValue = this.currentValue + 2;
        return this.currentValue;
    }

    @Override
    public void restart() {
        this.currentValue = this.initialValue;
        this.nextValue = this.initialValue;
    }

    @Override
    public void setInitialValue(Object value) {
        this.initialValue = (int) value;
        this.currentValue = (int) value;
        this.nextValue = (int) value;
    }
}
