package com.hemardvignol.webapp1.repository;


import com.hemardvignol.webapp1.CustomProperties;
import com.hemardvignol.webapp1.model.Produit;
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
public class ProduitProxy {

    @Autowired
    private CustomProperties props;


    public Iterable<Produit> getProduit() {

        String baseApiUrl = props.getApiUrl();
        String getProduitsUrl = baseApiUrl + "/produits";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Produit>> response = restTemplate.exchange(
                getProduitsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Produit>>() {}
        );

        log.debug("Get Produits call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Produit getProduit(int id) {
        String baseApiUrl = props.getApiUrl();
        String getProduitUrl = baseApiUrl + "/produit/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Produit> response = restTemplate.exchange(
                getProduitUrl,
                HttpMethod.GET,
                null,
                Produit.class
        );

        log.debug("Get Produit call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Produit createProduit(Produit p) {
        String baseApiUrl = props.getApiUrl();
        String createProduitUrl = baseApiUrl + "/produit";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Produit> request = new HttpEntity<Produit>(p);
        ResponseEntity<Produit> response = restTemplate.exchange(
                createProduitUrl,
                HttpMethod.POST,
                request,
                Produit.class);

        log.debug("Create Produit call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Produit updateProduit(Produit p) {
        String baseApiUrl = props.getApiUrl();
        String updateProduitUrl = baseApiUrl + "/produit/" + p.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Produit> request = new HttpEntity<Produit>(p);
        ResponseEntity<Produit> response = restTemplate.exchange(
                updateProduitUrl,
                HttpMethod.PUT,
                request,
                Produit.class);

        log.debug("Update Produit call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteProduit(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteProduitUrl = baseApiUrl + "/produit/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteProduitUrl,
                HttpMethod.DELETE,
                null,
                Void.class);
        log.debug("Delete Produit call " + response.getStatusCode().toString());
    }

    public Produit saveProduit(Produit produit) {
        Produit savedProduit;


        if(produit.getId() == null){
            savedProduit = createProduit(produit);
        } else {
            savedProduit = updateProduit(produit);
        }
        return savedProduit;
    }

}