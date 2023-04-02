package com.hemardvignol.api.repository;

import com.hemardvignol.api.model.Devis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends CrudRepository<Devis, Long>{
}
