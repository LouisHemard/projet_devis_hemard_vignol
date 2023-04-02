package com.hemardvignol.api.controller;

import com.hemardvignol.api.model.Devis;
import com.hemardvignol.api.model.DevisProduit;
import com.hemardvignol.api.service.DevisProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DevisProduitController {

    @Autowired
    private DevisProduitService devisProduitService;

    /**
     * Create - Add a new employee
     * @param devisProduit An object employee
     * @return The employee object saved
     */
    @PostMapping("/devisproduit")
    public DevisProduit createDevisProduit(@RequestBody DevisProduit devisProduit) {
        return devisProduitService.saveDevisProduit(devisProduit);
    }


    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/devisproduit/{id}")
    public DevisProduit getDevisProduit(@PathVariable("id") final Long id) {
        Optional<DevisProduit> devisProduit = devisProduitService.getDevisProduit(id);
        if(devisProduit.isPresent()) {
            return devisProduit.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all employees
     * @return - An Iterable object of Client full filled
     */

    @GetMapping("/devisproduits")
    public Iterable<DevisProduit> getDevisProduit() {
        return devisProduitService.getDevisProduits();
    }

    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param client - The employee object updated
     * @return
     */





    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/devisproduit/{id}")
    public void deleteDevisProduit(@PathVariable("id") final Long id) {
        devisProduitService.deleteDevisProduit(id);
    }


}