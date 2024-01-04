package clases.interfaces;

import java.util.List;

public interface Crud <T>{

    void alta(T elemento);
    void baja(int dni);
    T buscar(int dni);
    void modificar(T elemento);
    List<T> listar();

}
