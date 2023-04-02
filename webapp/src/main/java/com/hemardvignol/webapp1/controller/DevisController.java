package com.hemardvignol.webapp1.controller;

import com.hemardvignol.webapp1.model.Devis;
import com.hemardvignol.webapp1.model.Client;
import com.hemardvignol.webapp1.repository.ClientProxy;
import com.hemardvignol.webapp1.repository.DevisProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Controller
public class DevisController {
    @Autowired
    private DevisProxy service;

    @Autowired
    private ClientProxy serviceclient;


    @GetMapping("/devis")
    public String devis(Model model) {
        Iterable<Devis> listDevis = service.getDevis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        model.addAttribute("deviss", listDevis);
        return "formListDevis";
    }



/*
    @GetMapping("/devis")
    public String devis(Model model) {
        List<Devis> listDevis = jdbcTemplate.query(
                "SELECT devis.id, client.nom as nomClient, devis.date_creation, devis.description " +
                        "FROM deviss " +
                        "JOIN client ON devis.client_id = client.id",
                (rs, rowNum) -> {
                    Devis devis = new Devis();
                    devis.setId(rs.getInt("id"));
                    devis.setClient(rs.getString("nomClient"));
                    devis.setDate_creation(rs.getDate("date_creation"));
                    devis.setDescription(rs.getString("description"));
                    return devis;
                });
        model.addAttribute("deviss", listDevis);
        return "formListDevis";
    }*/

    @GetMapping("/deleteDevis/{id}")
    public ModelAndView deleteDevis(@PathVariable("id") final int id) {
        try {
            service.deleteDevis(id);
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "Une erreur est survenue lors de la suppression du devis.");
            return modelAndView;
        }
        return new ModelAndView("redirect:/devis");
    }

    @GetMapping("/createDevis")
    public String createDevis(Model model) {
        Devis d = new Devis();
        Iterable<Client> listClient = serviceclient.getClient();
        model.addAttribute("clients", listClient);
        model.addAttribute("devis", d);
        return "formNewDevis";
    }

    @GetMapping("/updateDevis/{id}")
    public String updateDevis(@PathVariable("id") final int id, Model model) {
        Devis d = service.getDevis(id);
        d.setDate_creation_formatted(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        model.addAttribute("devis", d);
        return "formUpdateDevis";
    }


    @PostMapping("/savedevis")
    public ModelAndView saveDevis(@ModelAttribute Devis devis) {
        if(devis.getId() != null) {
            Devis current = service.getDevis(devis.getId());
        }
        service.saveDevis(devis);
        return new ModelAndView("redirect:/devis");
    }
}