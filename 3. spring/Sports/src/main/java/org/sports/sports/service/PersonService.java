package org.sports.sports.service;

import org.sports.sports.dto.SportPersonDTO;
import org.sports.sports.entity.Person;
import org.sports.sports.repository.PersonRepository;
import org.sports.sports.repository.SportRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private final PersonRepository PERSON_REPOSITORY = new PersonRepository();
    private final SportService SPORT_SERVICE = new SportService();

    List<Person> res = PERSON_REPOSITORY.add(new Person("John", "Smith", 20));
    List<Person> res2 = PERSON_REPOSITORY.add(new Person("Jane", "Doe", 30));

    public List<SportPersonDTO> getPersonAndSport() {
        var sports = SPORT_SERVICE.getAll();
        List<SportPersonDTO> acc = new ArrayList<>();
        final int MIN = -1;

        PERSON_REPOSITORY.getPeople().forEach(person -> {
            int randomId = (int) Math.floor(Math.random() * (sports.size() - MIN) + MIN);

            if (randomId > 0)
                acc.add(new SportPersonDTO(person.getName(), person.getSurname(), sports.get(randomId).getName()));
        });

        return acc;
    }
}
