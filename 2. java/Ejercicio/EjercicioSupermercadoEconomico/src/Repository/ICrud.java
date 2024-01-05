package Repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {
    void mostrar();
    void guardar(T obj);
    void eliminar(Long id);
    List<T> consultarTodos();
    Optional<T> buscar(Long id);
    //void actualizar();
}
