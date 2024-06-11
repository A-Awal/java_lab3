package com.example.java_lab5.api;

import com.example.java_lab5.application.ProductService;
import com.example.java_lab5.application.dtos.ProductDto;
import com.example.java_lab5.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/product")
//@EnableMethodSecurity(jsr250Enabled = true)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){

        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productdto, UriComponentsBuilder ucBuilder){

        Product product = new Product();
        product.setName(productdto.getName());
        product.setPrice(productdto.getPrice());
        product.setQuantity(productdto.getQuantity());

        var savedProduct = productService.save(product);

        URI locationOfNewProduct= UriComponentsBuilder
                .fromPath("/api/product/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();

       return ResponseEntity.created(locationOfNewProduct).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        return ResponseEntity.ok( productService.findOne(id));
    }
}
