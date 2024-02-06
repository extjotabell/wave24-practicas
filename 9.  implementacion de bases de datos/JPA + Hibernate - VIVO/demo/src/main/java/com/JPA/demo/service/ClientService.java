package com.JPA.demo.service;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.entity.Client;
import com.JPA.demo.repository.IClientRepository;
import com.JPA.demo.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    @Autowired
    IClientRepository clientRepository;

    @Override
    public ClientDTO saveEntity(ClientDTO personDTO) {
        Client clientEntity = new Client(
                personDTO.id(),
                personDTO.email(),
                personDTO.cardNumber()
        );

        // Save() - Guarda o actualiza dependiendo de:
        // Si se manda un id null, lo crea
        // Si se manda un id que existe, lo actualiza
        // Si se manda un id no null que no existe, ej... 8, lo crea con id 8 o el que corresponda segun estrategia.
        clientEntity = clientRepository.save(clientEntity);

        return new ClientDTO(
                clientEntity.getId(),
                clientEntity.getEmail(),
                clientEntity.getCardNumber()
        );
    }

    @Override
    public ClientDTO getEntityById(Integer integer) {
        Client client = clientRepository.findById(integer).orElseThrow();

        return new ClientDTO(
                client.getId(),
                client.getEmail(),
                client.getCardNumber()
        );
    }

    @Override
    public List<ClientDTO> getAllEntities() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map(
                client -> new ClientDTO(
                        client.getId(),
                        client.getEmail(),
                        client.getCardNumber()
                )
        ).toList();
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }

    @Override
    public ClientDTO findByEmail(String email) {
        var client = clientRepository.findByEmailEquals(email).orElseThrow();

        return new ClientDTO(
                client.getId(),
                client.getEmail(),
                client.getCardNumber()
        );
    }
}
