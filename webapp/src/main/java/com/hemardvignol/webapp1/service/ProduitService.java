package com.hemardvignol.webapp1.service;


import com.hemardvignol.webapp1.model.Produit;
import com.hemardvignol.webapp1.repository.ProduitProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ProduitService {


    @Autowired
    private ProduitProxy produitProxy;

    public Produit getProduit(final int id) {
        return produitProxy.getProduit(id);
    }

    public Iterable<Produit> getProduits() {
        return produitProxy.getProduit();
    }

    public void deleteProduit(final int id) {
        produitProxy.deleteProduit(id);
    }

    public void createProduit(final Produit p) {
        produitProxy.createProduit(p);
    }

    public void updateProduit(final Produit p){produitProxy.updateProduit(p);}
}



