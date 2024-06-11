package com.example.java_lab4.Part_4;

import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService {
    public ProductService(ProductRepository userRepo) {
        super(userRepo);
    }
}
