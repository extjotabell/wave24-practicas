package org.sports.sports.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sports.sports.entity.Person;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRepository implements Repository<Person> {
    private ArrayList<Person> people;

    public List<Person> add(Person person) {
        if (people == null)
            people = new ArrayList<>();

        people.add(person);

        return people;
    }
    public List<Person> getAll() {
        return people;
    }
    public Person delete(String name) {
        var elementToRemove = people.stream().filter(p -> p.getName().equals(name));
        people = (ArrayList<Person>) people.stream().filter(p ->!p.getName().equals(name)).toList();

        return (Person) elementToRemove;
    }
    public Person getByName(String name) {
        return (Person) people.stream().filter(p -> p.getName().equals(name));
    }
}
