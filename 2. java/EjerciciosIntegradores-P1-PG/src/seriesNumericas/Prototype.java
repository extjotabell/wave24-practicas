package seriesNumericas;

public abstract class Prototype {
    Object initialValue;
    public abstract Object getNextValue();
    public abstract void restart();
    public abstract void setInitialValue(Object value);
}
