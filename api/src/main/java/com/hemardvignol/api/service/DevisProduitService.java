package com.hemardvignol.api.service;

import com.hemardvignol.api.model.DevisProduit;
import com.hemardvignol.api.repository.DevisProduitRepository;
import com.hemardvignol.api.repository.DevisRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class DevisProduitService {

    @Autowired
    private DevisProduitRepository devisProduitRepository;

    public Optional<DevisProduit> getDevisProduit(final Long id) {
        return devisProduitRepository.findById(id);
    }

    public Iterable<DevisProduit> getDevisProduits() {
        return devisProduitRepository.findAll();
    }

    public void deleteDevisProduit(final Long id) {
        devisProduitRepository.deleteById(id);
    }

    public DevisProduit saveDevisProduit(DevisProduit devisProduit) {
        DevisProduit savedDevisProduit = devisProduitRepository.save(devisProduit);
        return savedDevisProduit;
    }
}