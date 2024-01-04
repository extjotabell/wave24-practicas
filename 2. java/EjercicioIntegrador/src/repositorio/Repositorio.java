package repositorio;

import java.util.Optional;

public interface Repositorio<T> {

    Optional<T> getById(Integer id);
    void deleteById(Integer id);
    void add(T obj);
}
