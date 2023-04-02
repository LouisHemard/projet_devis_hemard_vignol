package com.hemardvignol.webapp1.model;

import lombok.Data;
@Data
public class Produit {
    private Integer id;

    private String nom;

    private String description;

    private Double largeur;

    private Double longueur;

    private Double hauteur;

    private Double ecart;

    private Boolean estComposant;

    private Boolean estCompose;

}

