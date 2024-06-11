package com.example.java_lab5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    int age;

    @OneToMany(mappedBy = "customer")
    Collection<Purchases> purchases;

}
