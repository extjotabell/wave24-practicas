package com.JPA.demo.service.impl;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.entity.Client;
import com.JPA.demo.entity.Person;
import com.JPA.demo.repository.interfaces.IClientRepository;
import com.JPA.demo.repository.interfaces.IPersonRespoistory;
import com.JPA.demo.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IPersonRespoistory personRepository;

    @Override
    public ClientDTO saveEntity(ClientDTO clientDTO) {
        Person person = personRepository.findById(clientDTO.personDTO().id()).orElseThrow();
        Client clientEntity = createClientEntity(clientDTO, person);
        clientEntity = clientRepository.save(clientEntity);
        return convertToDTO(clientEntity);
    }

    @Override
    public ClientDTO getEntityById(Integer integer) {
        Client clientEntity = clientRepository.findById(integer).orElseThrow();
        return convertToDTO(clientEntity);
    }

    @Override
    public List<ClientDTO> getAllEntities() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Page<ClientDTO> getAllEntities(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(this::convertToDTO);
    }

    @Override
    public MessageDTO deleteEntity(Integer id) {
        clientRepository.deleteById(id);
        if (clientRepository.existsById(id))
            return new MessageDTO("The client with id was deleted: " + id, "Delete");
        else
            return new MessageDTO("The client with id does not exist or could not be deleted:" + id, "Delete");
    }

    public ClientDTO findByEmail(String email) {
        Sort sort = Sort.by(Sort.Direction.ASC, "email");
        Client clientEntity = clientRepository.findByEmailEquals(email, sort).orElseThrow();
        return convertToDTO(clientEntity);
    }

    private Client createClientEntity(ClientDTO clientDTO, Person person) {
        return new Client(
                clientDTO.id(),
                clientDTO.email(),
                clientDTO.cardNumber(),
                person
        );
    }

    private ClientDTO convertToDTO(Client clientEntity) {
        return new ClientDTO(
                clientEntity.getId(),
                clientEntity.getEmail(),
                clientEntity.getCardNumber(),
                convertToPersonDTO(clientEntity.getPerson())
        );
    }

    private PersonDTO convertToPersonDTO(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getFirstname(),
                person.getLastname(),
                person.getDni(),
                person.getBirthDate(),
                person.getAge(),
                person.getSalary()
        );
    }
}
