package com.hemardvignol.webapp1.service;


import com.hemardvignol.webapp1.model.Client;
import com.hemardvignol.webapp1.repository.ClientProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ClientService {


    @Autowired
    private ClientProxy clientProxy;

    public Client getClient(final int id) {
        return clientProxy.getClient(id);
    }

    public Iterable<Client> getClients() {
        return clientProxy.getClient();
    }

    public void deleteClient(final int id) {
        clientProxy.deleteClient(id);
    }

    public void createClient(final Client c) {
        clientProxy.createClient(c);
    }

    public void updateClient(final Client c){clientProxy.updateClient(c);}
}



