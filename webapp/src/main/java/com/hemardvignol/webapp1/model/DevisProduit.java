package com.hemardvignol.webapp1.model;

import lombok.Data;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Data
public class DevisProduit {
    private Integer id;
    private Devis devis;
    private Produit produit;
    private Integer quantite;
    private String unite;

}