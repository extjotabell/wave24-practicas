package interfaces;

import java.util.ArrayList;
import java.util.List;

public interface Crud <T>{
    void save(T obj);
    void delete(T obj);
    void modify(T obj);
    List<T> list();
}
