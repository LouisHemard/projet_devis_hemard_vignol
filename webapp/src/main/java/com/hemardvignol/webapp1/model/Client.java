package com.hemardvignol.webapp1.model;

import lombok.Data;

@Data
public class Client {

    private Integer id;

    private String societeNom;

    private String mail;

    private String tel;

    private String adresse;

    private String codePostal;

    private String ville;

    private String pays;

}