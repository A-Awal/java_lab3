package com.example.java_lab4.Part_4;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class BaseRepository {
    private final Set<Product> products = new HashSet<>();

    public Product findById(int id) {
        return products.stream().filter(u->u.getId() == id).findFirst().orElse(null);
    }

    public Iterable<Product> findAll() {
        return products;
    }

    public int add(Product product) {
        Random random = new Random();
        var productID = random.nextInt(100);
        product.setId(productID);
        products.add(product);
        return productID;
    }

    public void   update(Product product){
        products.add(product);

    }

    public boolean deleteById(Product product) {
        return products.remove(product);
    }

}
