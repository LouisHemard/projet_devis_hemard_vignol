package com.hemardvignol.webapp1.controller;

import com.hemardvignol.webapp1.model.Client;
import com.hemardvignol.webapp1.repository.ClientProxy;
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
public class ClientController {
    @Autowired
    private ClientProxy service;

    @GetMapping("/client")
    public String client(Model model) {
        Iterable<Client> listClient = service.getClient();
        model.addAttribute("clients", listClient);
        return "formListClient";
    }



    @GetMapping("/deleteClient/{id}")
    public ModelAndView deleteClient(@PathVariable("id") final int id) {
        try {
            service.deleteClient(id);
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "Une erreur est survenue lors de la suppression du client. Ce client est surement utilisé dans un devis.");
            return modelAndView;
        }
        return new ModelAndView("redirect:/client");
    }

    @GetMapping("/createClient")
    public String createClient(Model model) {
        Client c = new Client();
        model.addAttribute("client", c);
        return "formNewClient";
    }

    @GetMapping("/updateClient/{id}")
    public String updateClient(@PathVariable("id") final int id, Model model) {
        Client c = service.getClient(id);
        model.addAttribute("client", c);
        return "formUpdateClient";
    }

    @PostMapping("/saveclient")
    public ModelAndView saveClient(@ModelAttribute Client client) {
        if(client.getId() != null) {
            Client current = service.getClient(client.getId());
        }
        service.saveClient(client);
        return new ModelAndView("redirect:/client");
    }

}