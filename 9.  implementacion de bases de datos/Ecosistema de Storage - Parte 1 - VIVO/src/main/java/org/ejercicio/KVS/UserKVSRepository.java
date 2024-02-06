package org.ejercicio.KVS;

import org.ejercicio.entity.User;

public interface UserKVSRepository {
    User findById(String id);
    void save(User user);
    void update(User user);
    void delete(String id);
}
