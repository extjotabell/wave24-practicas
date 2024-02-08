package com.JPA.demo.service.impl;

import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.entity.Person;
import com.JPA.demo.repository.interfaces.IPersonRespoistory;
import com.JPA.demo.service.interfaces.IPersonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {

    @Autowired
    IPersonRespoistory personRepository;

    @Override
    public PersonDTO saveEntity(PersonDTO personDTO) {
        Person personEntity = mapToEntity(personDTO);
        personEntity = personRepository.save(personEntity);
        return mapToDTO(personEntity);
    }

    @Override
    public PersonDTO getEntityById(Integer id) {
        Person personEntity = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + id));
        return mapToDTO(personEntity);
    }

    @Override
    public List<PersonDTO> getAllEntities() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Integer id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return new MessageDTO("Se eliminó el person con id: " + id, "Eliminacion");
        } else {
            return new MessageDTO("No existe o no se pudo eliminar el person con id: " + id, "Eliminacion");
        }
    }

    private Person mapToEntity(PersonDTO personDTO) {
        return new Person(
                personDTO.id(),
                personDTO.firstname(),
                personDTO.lastname(),
                personDTO.dni(),
                personDTO.birthDate(),
                personDTO.age(),
                personDTO.salary()
        );
    }

    private PersonDTO mapToDTO(Person personEntity) {
        return new PersonDTO(
                personEntity.getId(),
                personEntity.getFirstname(),
                personEntity.getLastname(),
                personEntity.getDni(),
                personEntity.getBirthDate(),
                personEntity.getAge(),
                personEntity.getSalary()
        );
    }

}