package com.JPA.demo.service;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.entity.Client;
import com.JPA.demo.entity.Person;
import com.JPA.demo.repository.interfaces.IClientRepository;
import com.JPA.demo.repository.interfaces.IPersonRepository;
import com.JPA.demo.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    IClientRepository clientRepository;


    @Autowired
    IPersonRepository personRepository;

    @Override
    public ClientDTO saveEntity(ClientDTO clientDTO) {

        Person person = personRepository.findById(clientDTO.personDTO().id()).orElseThrow();

        Client clientEntity = new Client(
                clientDTO.id(),
                clientDTO.email(),
                clientDTO.cardNumber(),
                person
        );

        // Save guarda o actualiza depende de:
        // Si mando un id null, lo crea
        // si mando un id que existe, lo actualiza
        // si mando un id no null que no existe, ej... 8, lo crea con id 8 o el que corresponda segun estrategia.
        clientEntity = clientRepository.save(clientEntity);

        return new ClientDTO(
                clientEntity.getId(),
                clientEntity.getEmail(),
                clientEntity.getCardNumber(),
                new PersonDTO(
                    clientEntity.getPerson().getId(),
                    clientEntity.getPerson().getFirstname(),
                    clientEntity.getPerson().getLastname(),
                    clientEntity.getPerson().getDni(),
                    clientEntity.getPerson().getBirthDate(),
                    clientEntity.getPerson().getAge(),
                    clientEntity.getPerson().getSalary()
                )
        );
    }

    @Override
    public ClientDTO getEntityById(Integer integer) {

        Client cliente = clientRepository.findById(integer)
                .orElseThrow();

        return new ClientDTO(
                cliente.getId(),
                cliente.getEmail(),
                cliente.getCardNumber(),
                new PersonDTO(
                        cliente.getPerson().getId(),
                        cliente.getPerson().getFirstname(),
                        cliente.getPerson().getLastname(),
                        cliente.getPerson().getDni(),
                        cliente.getPerson().getBirthDate(),
                        cliente.getPerson().getAge(),
                        cliente.getPerson().getSalary()
                )
        );
    }

    @Override
    public List<ClientDTO> getAllEntities() {
        return null;
    }

    @Override
    public Page<ClientDTO> getAllEntities(int page, int size) {

        // Pageable sirve para paginar en base a dos parametros, la pagina y el tamaño de cada una.
        Pageable pageable = PageRequest.of(page, size);

        Page<Client> clients = clientRepository.findAll(pageable);

        var pages = clients.map(
                client -> new ClientDTO(
                        client.getId(),
                        client.getEmail(),
                        client.getCardNumber(),
                        new PersonDTO(
                                client.getPerson().getId(),
                                client.getPerson().getFirstname(),
                                client.getPerson().getLastname(),
                                client.getPerson().getDni(),
                                client.getPerson().getBirthDate(),
                                client.getPerson().getAge(),
                                client.getPerson().getSalary()
                )));

        return pages;


    }

    @Override
    public MessageDTO deleteEntity(Integer id) {

        clientRepository.deleteById(id);
        if(clientRepository.existsById(id))
            return new MessageDTO(
                    "Se eliminó el cliente con id: " + id,
                    "Eliminacion"
            );
        else
            return new MessageDTO(
                    "No existe o no se pudo eliminar el cliente con id: " + id,
                    "Eliminacion"
            );
    }

    public ClientDTO findByEmail(String email) {

        Sort sort = Sort.by(Sort.Direction.ASC, "email");

        var cliente = clientRepository.findByEmailEquals(email, sort)
                .orElseThrow();

        return new ClientDTO(
                cliente.getId(),
                cliente.getEmail(),
                cliente.getCardNumber(),
                new PersonDTO(
                        cliente.getPerson().getId(),
                        cliente.getPerson().getFirstname(),
                        cliente.getPerson().getLastname(),
                        cliente.getPerson().getDni(),
                        cliente.getPerson().getBirthDate(),
                        cliente.getPerson().getAge(),
                        cliente.getPerson().getSalary()
                ));
    }
}
