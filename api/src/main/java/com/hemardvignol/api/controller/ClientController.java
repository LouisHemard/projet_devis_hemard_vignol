package com.hemardvignol.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hemardvignol.api.model.Client;
import com.hemardvignol.api.service.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping("/client")
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }



    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable("id") final Long id) {
        Optional<Client> client = clientService.getClient(id);
        if(client.isPresent()) {
            return client.get();
        } else {
            return null;
        }
    }

    @GetMapping("/clients")
    public Iterable<Client> getClients() {
        return clientService.getClients();
    }



    @PutMapping("/client/{id}")
    public Client updateClient(@PathVariable("id") final Long id, @RequestBody Client client) {
        Optional<Client> c = clientService.getClient(id);
        if(c.isPresent()) {
            Client currentClient = c.get();

            String societe_nom = client.getSocieteNom();
            if(societe_nom != null) {
                currentClient.setSocieteNom(societe_nom);
            }
            String mail = client.getMail();
            if(mail != null) {
                currentClient.setMail(mail);
            }
            String tel = client.getTel();
            if(tel != null) {
                currentClient.setTel(tel);;
            }
            String adresse = client.getAdresse();
            if(adresse != null) {
                currentClient.setAdresse(adresse);;
            }
            String code_postal = client.getCodePostal();
            if(code_postal != null) {
                currentClient.setCodePostal(code_postal);;
            }
            String ville = client.getVille();
            if(ville != null) {
                currentClient.setVille(ville);;
            }
            String pays = client.getPays();
            if(pays != null) {
                currentClient.setPays(pays);;
            }
            clientService.saveClient(currentClient);
            return currentClient;
        } else {
            return null;
        }
    }


    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") final Long id) {
        clientService.deleteClient(id);
    }

}