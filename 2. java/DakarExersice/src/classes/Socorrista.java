package classes;

public abstract class Socorrista<T extends Vehiculo> {
    public abstract boolean socorrer(T vehiculo);
}
