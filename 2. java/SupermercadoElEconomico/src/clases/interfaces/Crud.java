package clases.interfaces;

import java.util.List;

public interface Crud <T>{

    void alta(T elemento);
    void baja(int elemento);
    T buscar(int elemento);
    T modificar(int elemento);

}
