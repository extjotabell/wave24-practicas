package ejerciciodos.classes;

public interface Imprimible<T extends Documento> {
    void print(T doc);
}
