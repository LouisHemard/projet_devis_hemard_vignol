package com.hemardvignol.api.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "devis_produits")
public class DevisProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "devis_id", nullable = false)
    private Devis devis;
    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;
    @Column(name = "quantite", nullable = false)
    private Integer quantite;
    @Column(name = "unite", nullable = false)
    private String unite;

}