package com.JPA.demo.repository.interfaces;

import com.JPA.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Integer> {

    // METODOS NOMBRADOS O NAMED METHODS
    Optional<Client> findByEmailEquals(String email);

}
