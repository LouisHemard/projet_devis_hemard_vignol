package com.hemardvignol.api.model;

import javax.persistence.*;
import lombok.Data;
import java.util.List;
import java.time.LocalDate;
import javax.persistence.OneToMany;

@Data
@Entity
@Table(name = "deviss")
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "date_creation", nullable = false)
    private LocalDate date_creation;

    @Column(name = "description")
    private String description;



}