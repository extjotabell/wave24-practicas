package org.sports.sports.repository;

import java.util.List;

public interface Repository<T> {
    List<T> add(T value);
    List<T> getAll();
    T getByName(String name);
    T delete(String name);
}
