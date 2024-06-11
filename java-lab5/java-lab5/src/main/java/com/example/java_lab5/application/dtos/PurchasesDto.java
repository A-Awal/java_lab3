package com.example.java_lab5.application.dtos;

import lombok.Data;

@Data
public class PurchasesDto {
    private int id;
    private String description;
    private double purchaseValue;
    private float quantity;
    Integer product_id;
    Integer customer_id;
}
