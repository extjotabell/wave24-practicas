package com.JPA.demo.repository;

import com.JPA.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByEmailEquals(String email);
}
