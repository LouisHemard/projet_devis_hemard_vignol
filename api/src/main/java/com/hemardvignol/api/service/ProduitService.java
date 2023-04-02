package com.hemardvignol.api.service;

import com.hemardvignol.api.model.Produit;
import com.hemardvignol.api.repository.ProduitRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Optional<Produit> getProduit(final Long id) {
        return produitRepository.findById(id);
    }

    public Iterable<Produit> getProduits() {
        return produitRepository.findAll();
    }

    public void deleteProduit(final Long id) {
        produitRepository.deleteById(id);
    }

    public Produit saveProduit(Produit produit) {
        Produit savedProduit = produitRepository.save(produit);
        return savedProduit;
    }
}