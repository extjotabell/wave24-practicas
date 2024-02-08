package com.JPA.demo.repository.interfaces;

import com.JPA.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonRespoistory extends JpaRepository<Person, Integer> {


    //TODO: findby + atributo + Operador + ...
    //Operadores logicos: Equals, NotEquals, Containing, NotContaining, StartingWith, EndingWith,
    // In, NotIn, LessThan, LessThanEqual, GreaterThan, GreaterThanEqual, Between, NotBetween,
    // IsNull, IsNotNull, True, False, And, Or, IgnoreCase, OrderBy, Not, Asc, Desc, Distinct
    List<Person> findByfirstnameEqualsAndlastnameEquals(String firstname, String lastname);

    List<Person> findByAgeGreaterThanEqual(Short age);

}
