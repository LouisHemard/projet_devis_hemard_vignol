package com.hemardvignol.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "societe_nom", nullable = false)
    private String societeNom;

    @Column(name = "mail")
    private String mail;

    @Column(name = "tel", nullable = false)
    private String tel;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "code_postal", nullable = false)
    private String codePostal;

    @Column(name = "ville", nullable = false)
    private String ville;

    @Column(name = "pays", nullable = false)
    private String pays;

}