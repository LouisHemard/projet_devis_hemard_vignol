package com.hemardvignol.api.controller;

import com.hemardvignol.api.model.Produit;
import com.hemardvignol.api.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    /**
     * Create - Add a new employee
     * @param produit An object employee
     * @return The employee object saved
     */
    @PostMapping("/produit")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }


    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/produit/{id}")
    public Produit getProduit(@PathVariable("id") final Long id) {
        Optional<Produit> produit = produitService.getProduit(id);
        if(produit.isPresent()) {
            return produit.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all employees
     * @return - An Iterable object of Client full filled
     */

    @GetMapping("/produits")
    public Iterable<Produit> getProduit() {
        return produitService.getProduits();
    }

    /**
     * Update - Update an existing employee
     * @param id - The id of the produit to update
     * @param produit - The produit object updated
     * @return
     */

    @PutMapping("/produit/{id}")
    public Produit updateProduit(@PathVariable("id") final Long id, @RequestBody Produit produit) {
        Optional<Produit> p = produitService.getProduit(id);
        if(p.isPresent()) {
            Produit currentProduit = p.get();

            String nom = produit.getNom();
            if(nom != null) {
                currentProduit.setNom(nom);
            }
            String description = produit.getDescription();
            if(description != null) {
                currentProduit.setDescription(description);
            }
            Double largeur = produit.getLargeur();
            if(largeur != null) {
                currentProduit.setLargeur(largeur);;
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
    }


    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */

    @DeleteMapping("/produit/{id}")
    public void deleteProduit(@PathVariable("id") final Long id) {
        produitService.deleteProduit(id);
    }


}