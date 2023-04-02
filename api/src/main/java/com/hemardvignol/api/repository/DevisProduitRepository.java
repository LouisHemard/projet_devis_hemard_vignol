package com.hemardvignol.api.repository;

import com.hemardvignol.api.model.DevisProduit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisProduitRepository extends CrudRepository<DevisProduit, Long>{
}
