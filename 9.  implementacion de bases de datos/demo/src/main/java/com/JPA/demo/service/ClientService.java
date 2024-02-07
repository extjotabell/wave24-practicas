package com.JPA.demo.service;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.entity.Client;
import com.JPA.demo.repository.interfaces.IClientRepository;
import com.JPA.demo.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    IClientRepository clientRepository;

    @Override
    public ClientDTO saveEntity(ClientDTO clientDTO) {

        Client clientEntity = new Client(
                clientDTO.id(),
                clientDTO.email(),
                clientDTO.cardNumber()
        );

        // Save guarda o actualiza depende de:
        // Si mando un id null, lo crea
        // si mando un id que existe, lo actualiza
        // si mando un id no null que no existe, ej... 8, lo crea con id 8 o el que corresponda segun estrategia.
        clientEntity = clientRepository.save(clientEntity);

        return new ClientDTO(
                clientEntity.getId(),
                clientEntity.getEmail(),
                clientEntity.getCardNumber()
        );
    }

    @Override
    public ClientDTO getEntityById(Integer integer) {

        Client cliente = clientRepository.findById(integer)
                .orElseThrow();

        return new ClientDTO(
                cliente.getId(),
                cliente.getEmail(),
                cliente.getCardNumber()
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

    public ClientDTO findByEmail(String email) {

        var cliente = clientRepository.findByEmailEquals(email).orElseThrow();

        return new ClientDTO(
                cliente.getId(),
                cliente.getEmail(),
                cliente.getCardNumber()
        );
    }
}
