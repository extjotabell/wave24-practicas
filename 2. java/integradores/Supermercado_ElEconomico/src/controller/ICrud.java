package controller;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {

    void mostrar();
    void guardar(T obj);
    void eliminar(int id );
    List<T> mostrarTodos();
    Optional<T> buscar(int id);

}
