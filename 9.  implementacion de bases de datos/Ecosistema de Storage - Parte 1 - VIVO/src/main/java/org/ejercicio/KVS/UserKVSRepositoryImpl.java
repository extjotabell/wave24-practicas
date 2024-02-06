package org.ejercicio.KVS;

import org.ejercicio.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

@Repository
public class UserKVSRepositoryImpl implements UserKVSRepository {

    @Value("${KEY_VALUE_STORE_MY_CONTAINER_CONTAINER_NAME}")
    private String keyValueStoreName;

    @Override
    @Retryable(value = {Exception.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public User findById(String id) {
        return null;
    }

    @Override
    @Retryable(value = {Exception.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public void save(User user) {
    }

    @Override
    @Retryable(value = {Exception.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public void update(User user) {
    }

    @Override
    @Retryable(value = {Exception.class}, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public void delete(String id) {
    }
}
