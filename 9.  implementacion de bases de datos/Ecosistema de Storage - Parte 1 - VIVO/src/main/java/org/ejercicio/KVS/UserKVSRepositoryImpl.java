package org.ejercicio.KVS;

import org.apache.coyote.BadRequestException;
import org.ejercicio.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserKVSRepositoryImpl implements UserKVSRepository {

    @Value("${KEY_VALUE_STORE_MY_CONTAINER_CONTAINER_NAME}")
    private String keyValueStoreName;

    private final List<User> USERS = new ArrayList<>();

    @Override
    @Retryable(value = {Exception.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public User findById(String id) {
        try {
            return USERS.stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new BadRequestException("User not found"));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Retryable(value = {Exception.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public void save(User user) {
        if(USERS.stream().anyMatch(u -> u.getId().equals(user.getId()))) {
            throw new RuntimeException("User already exists");
        }
        USERS.add(user);
    }

    @Override
    @Retryable(value = {Exception.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public void update(User user) {
        if(USERS.stream().anyMatch(u -> u.getId().equals(user.getId()))) {
            USERS.remove(user);
            USERS.add(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    @Retryable(value = {Exception.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public void delete(String id) {
        if(USERS.stream().anyMatch(u -> u.getId().equals(id))) {
            USERS.removeIf(user -> user.getId().equals(id));
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
