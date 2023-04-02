package com.hemardvignol.api.repository;

import com.hemardvignol.api.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long>{
}
