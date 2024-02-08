package com.JPA.demo.repository.interfaces;

import com.JPA.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

    // TODO: findBy + atributo + operador + ...
    // Operadores logicos : AND - OR - EQUALS - CONTAINS - NOT EQUALS - LESS THAN EQUALS
    List<Person> findByFirstnameEqualsAndLastnameEquals(String firstName, String lastName);

    List<Person> findByAgeGreaterThanEqual(Short age);


    // FirstNameLike
    // string firstname = "%as"


    // FirstNameEndingWith = "%as"
    // FirstNameStartingWith = "as%"
    // FirstNameContaining = "%as%"
}
