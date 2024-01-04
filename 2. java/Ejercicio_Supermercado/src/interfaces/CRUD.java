package interfaces;

import java.util.List;

public interface CRUD<T> {

    public T agregar(T t);
    public List<T> listar();
    public T editar(int id, T t);
    public void eliminar(int id);

}
