package com.hemardvignol.webapp1.controller;

import com.hemardvignol.webapp1.model.Produit;
import com.hemardvignol.webapp1.repository.ProduitProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class ProduitController {
    @Autowired
    private ProduitProxy service;

    @GetMapping("/produit")
    public String produit(Model model) {
        Iterable<Produit> listProduit = service.getProduit();
        model.addAttribute("produits", listProduit);
        return "formListProduit";
    }

    @GetMapping("/deleteProduit/{id}")
    public ModelAndView deleteProduit(@PathVariable("id") final int id) {
        try {
            service.deleteProduit(id);
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "Une erreur est survenue lors de la suppression du produit. " +
                    "Il est probablement utilisé dans un composant ou un devis déjà enregistré");
            return modelAndView;
        }
        return new ModelAndView("redirect:/produit");
    }

    @GetMapping("/createProduit")
    public String createProduit(Model model) {
        Produit p = new Produit();
        model.addAttribute("produit", p);
        return "formNewProduit";
    }

    @GetMapping("/updateProduit/{id}")
    public String updateProduit(@PathVariable("id") final int id, Model model) {
        Produit p = service.getProduit(id);
        model.addAttribute("produit", p);
        return "formUpdateProduit";
    }


    @PostMapping("/saveproduit")
    public ModelAndView saveProduit(@ModelAttribute Produit produit) {
        if(produit.getId() != null) {
            Produit current = service.getProduit(produit.getId());
        }
        service.saveProduit(produit);
        return new ModelAndView("redirect:/produit");
    }

}