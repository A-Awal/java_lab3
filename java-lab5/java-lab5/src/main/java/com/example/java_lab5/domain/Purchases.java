package com.example.java_lab5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
@Entity
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private double purchaseValue;
    private float quantity;

    private Date purchaseDate=new Date();

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;


}