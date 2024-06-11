package com.example.java_lab5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    String name;
    int price;
    int quantity;

    @OneToMany(mappedBy = "product")
    List<Purchases> purchases;
}
