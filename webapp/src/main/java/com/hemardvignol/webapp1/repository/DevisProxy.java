package com.hemardvignol.webapp1.repository;


import com.hemardvignol.webapp1.CustomProperties;
import com.hemardvignol.webapp1.model.Devis;
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
public class DevisProxy {

    @Autowired
    private CustomProperties props;


    public Iterable<Devis> getDevis() {

        String baseApiUrl = props.getApiUrl();
        String getDevissUrl = baseApiUrl + "/deviss";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Devis>> response = restTemplate.exchange(
                getDevissUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Devis>>() {}
        );

        log.debug("Get Deviss call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Devis getDevis(int id) {
        String baseApiUrl = props.getApiUrl();
        String getDevisUrl = baseApiUrl + "/devis/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Devis> response = restTemplate.exchange(
                getDevisUrl,
                HttpMethod.GET,
                null,
                Devis.class
        );

        log.debug("Get Devis call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Devis createDevis(Devis c) {
        String baseApiUrl = props.getApiUrl();
        String createDevisUrl = baseApiUrl + "/devis";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Devis> request = new HttpEntity<Devis>(c);
        ResponseEntity<Devis> response = restTemplate.exchange(
                createDevisUrl,
                HttpMethod.POST,
                request,
                Devis.class);

        log.debug("Create Devis call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Devis updateDevis(Devis c) {
        String baseApiUrl = props.getApiUrl();
        String updateDevisUrl = baseApiUrl + "/devis/" + c.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Devis> request = new HttpEntity<Devis>(c);
        ResponseEntity<Devis> response = restTemplate.exchange(
                updateDevisUrl,
                HttpMethod.PUT,
                request,
                Devis.class);

        log.debug("Update Devis call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteDevis(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteDevisUrl = baseApiUrl + "/devis/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteDevisUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Devis call " + response.getStatusCode().toString());
    }

    public Devis saveDevis(Devis devis) {
        Devis savedDevis;


        if(devis.getId() == null){
            savedDevis = createDevis(devis);
        } else {
            savedDevis = updateDevis(devis);
        }
        return savedDevis;
    }


}