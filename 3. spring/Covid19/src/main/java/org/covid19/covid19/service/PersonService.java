package org.covid19.covid19.service;

import org.covid19.covid19.dto.RiskPersonDTO;
import org.covid19.covid19.entity.Person;
import org.covid19.covid19.reposirtory.PersonRepository;
import org.covid19.covid19.reposirtory.SymptomRepository;

import java.util.List;

public class PersonService {
    private static final PersonRepository PERSON_REPOSITORY = new PersonRepository();

    public List<Person> findAll() {
        return PERSON_REPOSITORY.findAll();
    }
    public Person save(Person person) {
        return PERSON_REPOSITORY.save(person);
    }
    public Person findById(Integer id) {
        return PERSON_REPOSITORY.findById(id);
    }
    public List<Person> update(Person person) {
        return PERSON_REPOSITORY.update(person);
    }
    public Person deleteById(Integer id) {
        return PERSON_REPOSITORY.deleteById(id);
    }
    public List<RiskPersonDTO> findRiskPeople() {
        var people = this.findAll();

        return people
                .stream()
                .filter(p -> p.getSymptoms() != null)
                .map(p -> new RiskPersonDTO(p.getName(), p.getSurname(), p.getSymptoms()))
                .toList();
    }
}
