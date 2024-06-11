package com.example.java_lab5.api;

import com.example.java_lab5.application.CustomerService;
import com.example.java_lab5.application.ProductService;
import com.example.java_lab5.application.PurchasesService;
import com.example.java_lab5.application.dtos.ProductDto;
import com.example.java_lab5.application.dtos.PurchasesDto;
import com.example.java_lab5.domain.Purchases;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchases")
//@EnableMethodSecurity(jsr250Enabled = true)
public class PurchsesController {
    private final ProductService productService;
    private final CustomerService customerService;
    private final PurchasesService purchasesService;

    public PurchsesController(ProductService productService, CustomerService customerService, PurchasesService purchasesService) {

        this.productService = productService;
        this.customerService = customerService;
        this.purchasesService = purchasesService;
    }
    @PostMapping
    public ResponseEntity addProduct(@RequestBody PurchasesDto purchasesDto) {

        var newPurchase = new Purchases();
        newPurchase.setQuantity(purchasesDto.getQuantity());
        newPurchase.setDescription(purchasesDto.getDescription());
        newPurchase.setPurchaseValue(purchasesDto.getPurchaseValue());

        newPurchase.setCustomer(customerService.findOne(purchasesDto.getCustomer_id()));
        newPurchase.setProduct(productService.findOne(purchasesDto.getProduct_id()));
        purchasesService.save(newPurchase);
        return ResponseEntity.ok().body(newPurchase);
    }

}
