package com.hemardvignol.webapp1.repository;


import com.hemardvignol.webapp1.CustomProperties;
import com.hemardvignol.webapp1.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ClientProxy {

    @Autowired
    private CustomProperties props;


    public Iterable<Client> getClient() {

        String baseApiUrl = props.getApiUrl();
        String getClientsUrl = baseApiUrl + "/clients";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Client>> response = restTemplate.exchange(
                getClientsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Client>>() {}
        );

        log.debug("Get Clients call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Client getClient(int id) {
        String baseApiUrl = props.getApiUrl();
        String getClientUrl = baseApiUrl + "/client/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Client> response = restTemplate.exchange(
                getClientUrl,
                HttpMethod.GET,
                null,
                Client.class
        );

        log.debug("Get Client call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Client createClient(Client c) {
        String baseApiUrl = props.getApiUrl();
        String createClientUrl = baseApiUrl + "/client";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Client> request = new HttpEntity<Client>(c);
        ResponseEntity<Client> response = restTemplate.exchange(
                createClientUrl,
                HttpMethod.POST,
                request,
                Client.class);

        log.debug("Create Client call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Client updateClient(Client c) {
        String baseApiUrl = props.getApiUrl();
        String updateClientUrl = baseApiUrl + "/client/" + c.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Client> request = new HttpEntity<Client>(c);
        ResponseEntity<Client> response = restTemplate.exchange(
                updateClientUrl,
                HttpMethod.PUT,
                request,
                Client.class);

        log.debug("Update Client call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteClient(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteClientUrl = baseApiUrl + "/client/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteClientUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Client call " + response.getStatusCode().toString());
    }

    public Client saveClient(Client client) {
        Client savedClient;


        if(client.getId() == null){
            savedClient = createClient(client);
        } else {
            savedClient = updateClient(client);
        }
        return savedClient;
    }

}