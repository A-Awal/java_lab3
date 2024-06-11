package com.example.java_lab4.Part_4;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService _productService;

    @Autowired
    public ProductController(ProductService productService) {
        _productService = productService;
    }

    @GetMapping()
    public ResponseEntity<Product> getProduct(@RequestParam int id){
        var product = _productService.findById(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO, UriComponentsBuilder ucBuilder){
        var productId = _productService.create(productDTO);

        if(productId <0){
            return ResponseEntity.badRequest().build();
        }

        URI locationOfNewProduct= UriComponentsBuilder
                .fromPath("/api/v1/products/{id}")
                .buildAndExpand(productId)
                .toUri();
        return ResponseEntity.created(locationOfNewProduct).build();
    }

    @PutMapping()
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable int id){
        try{
            _productService.update(productDTO, id);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestParam int id){
        if(_productService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
