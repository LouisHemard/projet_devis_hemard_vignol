package com.hemardvignol.api.service;

import java.util.Optional;

import com.hemardvignol.api.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hemardvignol.api.repository.ClientRepository;

import lombok.Data;

@Data
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> getClient(final long id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> getClients() {
        return clientRepository.findAll();
    }

    public void deleteClient(final Long id) {
        clientRepository.deleteById(id);
    }

    public Client saveClient(Client client) {
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }
}