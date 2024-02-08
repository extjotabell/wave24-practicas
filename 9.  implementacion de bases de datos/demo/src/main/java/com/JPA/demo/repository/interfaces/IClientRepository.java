package com.JPA.demo.repository.interfaces;

import com.JPA.demo.entity.Client;
import com.JPA.demo.entity.template.ClientSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Integer> {

    // METODOS NOMBRADOS O NAMED METHODS
    Optional<Client> findByEmailEquals(String email, Sort sort);


    @Query("FROM Client c WHERE c.person.dni = :dni")
    List<Client> findByPersonDniEquals(@Param(value = "dni") String dni);


    @Query("SELECT new com.JPA.demo.entity.template.ClientSummary(c.id, c.email, c.person.lastname, c.person.firstname, c.person.age)" +
            "FROM Client c WHERE c.id = :id")
    ClientSummary getSummaryOfClient(@Param(value = "id") Integer id);


    @Query("SELECT AVG(c.person.age) FROM Client c")
    Long getAverageOfAges();


}
