package com.hemardvignol.webapp1.model;

import lombok.Data;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Data
public class Devis {

    private Integer id;

    private Client Client;

    private Date date_creation;
    private String date_creation_formatted;

    public String getDate_creation_formatted() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = formatter.format(this.date_creation);
        return formattedDate;
    }

    public void setDate_creation_formatted(String date_creation_formatted) {
        this.date_creation_formatted = date_creation_formatted;
    }
    private String description;

}