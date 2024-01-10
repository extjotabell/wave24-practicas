package org.covid19.covid19.reposirtory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.covid19.covid19.entity.Person;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonRepository implements CrudRepository<Person> {
    List<Person> people = new ArrayList<>();

    @Override
    public List<Person> findAll() {
        return people;
    }
    @Override
    public Person save(Person person) {
        people.add(person);

        return person;
    }
    @Override
    public Person findById(Integer id) {
        try {
            return people
                    .stream()
                    .filter(person -> person.getId().equals(id)).findFirst().orElseThrow(null);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("Person with id %d not found: %s", id, e.getMessage())
            );
        }
    }
    @Override
    public List<Person> update(Person person) {
        return people
                .stream()
                .map(p -> {
                    if (p.getId().equals(person.getId()))
                        return person;

                    return p;
                })
                .toList();
    }
    @Override
    public Person deleteById(Integer id) {
        try {
            var personToDelete = people
                    .stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElseThrow(null);

            people.remove(personToDelete);

            return personToDelete;
        }
        catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("Person with id %d not found: %s", id, e.getMessage())
            );
        }
    }
}
