package com.hemardvignol.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@Entity
@Table(name = "produits")
public class Produit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "largeur")
    private Double largeur;

    @Column(name = "longueur")
    private Double longueur;

    @Column(name = "hauteur")
    private Double hauteur;

    @Column(name = "ecart")
    private Double ecart;

    @Column(name = "est_composant", nullable = false)
    private Boolean estComposant;

    @Column(name = "est_compose", nullable = false)
    private Boolean estCompose;

}