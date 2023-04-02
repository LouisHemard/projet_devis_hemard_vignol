package com.hemardvignol.api.controller;

import com.hemardvignol.api.model.Client;
import com.hemardvignol.api.model.Devis;
import com.hemardvignol.api.model.Produit;
import com.hemardvignol.api.service.DevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DevisController {

    @Autowired
    private DevisService devisService;

    /**
     * Create - Add a new employee
     * @param devis An object employee
     * @return The employee object saved
     */
    @PostMapping("/devis")
    public Devis createDevis(@RequestBody Devis devis) {
        return devisService.saveDevis(devis);
    }


    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Devis object
     */
    @GetMapping("/devis/{id}")
    public Devis getDevis(@PathVariable("id") final Long id) {
        Optional<Devis> devis = devisService.getDevis(id);
        if(devis.isPresent()) {
            return devis.get();
        } else {
            return null;
    }
    }

    /**
     * Read - Get all employees
     * @return - An Iterable object of Client full filled
     */

    @GetMapping("/deviss")
    public Iterable<Devis> getDevis() {
        return devisService.getDeviss();
    }

    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/devis/{id}")
    public void deleteDevis(@PathVariable("id") final Long id) {
        devisService.deleteDevis(id);
    }

/*
    @PutMapping("/devis/{id}")
    public Devis updateDevis(@PathVariable("id") final Long id, @RequestBody Devis devis) {
        Optional<Devis> d = devisService.getDevis(id);
        if(d.isPresent()) {
            Devis currentDevis = d.get();

            Client client = devis.getClient();
            if(client != null) {
                currentDevis.setClient(client);
            }
            String description = devis.getDescription();
            if(description != null) {
                currentDevis.setDescription(description);
            }
            Double date_creation = devis.getDateCreation();
            if(date_creation != null) {
                currentDevis.setDateCreation(date_creation);;
            }
            Double longueur = produit.getLongueur();
            if(longueur != null) {
                currentProduit.setLongueur(longueur);;
            }
            Double hauteur = produit.getHauteur();
            if(hauteur != null) {
                currentProduit.setHauteur(hauteur);;
            }
            Double ecart = produit.getEcart();
            if(ecart != null) {
                currentProduit.setEcart(ecart);;
            }
            produitService.saveProduit(currentProduit);
            return currentProduit;
        } else {
            return null;
        }
    }*/
}