package com.hemardvignol.webapp1.service;


import com.hemardvignol.webapp1.model.Devis;
import com.hemardvignol.webapp1.repository.DevisProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class DevisService {


    @Autowired
    private DevisProxy devisProxy;

    public Devis getDevis(final int id) {
        return devisProxy.getDevis(id);
    }

    public Iterable<Devis> getDeviss() {
        return devisProxy.getDevis();
    }

    public void deleteDevis(final int id) {
        devisProxy.deleteDevis(id);
    }

    public void createDevis(final Devis c) {
        devisProxy.createDevis(c);
    }

    public void updateDevis(final Devis c){devisProxy.updateDevis(c);}
}



