package interfaces;

public interface Repositorio <T>{
    void save(T obj);
    void delete(T obj);
    T getById(Long id);
}
