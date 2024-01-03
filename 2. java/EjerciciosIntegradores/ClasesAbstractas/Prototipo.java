public abstract class Prototipo <T extends Number> {
    protected final T INDEX;
    protected T counter;

    public Prototipo(T INDEX) {
        this.INDEX = INDEX;
    }

    public abstract T getNextValue();

    public void reset() {
        counter = INDEX;
    }

    public abstract void setInitValue(T valor);
}