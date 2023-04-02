package com.hemardvignol.api.service;

import com.hemardvignol.api.model.Devis;
import com.hemardvignol.api.repository.DevisRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class DevisService {

    @Autowired
    private DevisRepository devisRepository;

    public Optional<Devis> getDevis(final Long id) {
        return devisRepository.findById(id);
    }

    public Iterable<Devis> getDeviss() {
        return devisRepository.findAll();
    }

    public void deleteDevis(final Long id) {
        devisRepository.deleteById(id);
    }

    public Devis saveDevis(Devis devis) {
        Devis savedDevis = devisRepository.save(devis);
        return savedDevis;
    }
}