package com.example.java_lab5.api;

import com.example.java_lab5.application.CustomerService;
import com.example.java_lab5.application.dtos.CustomerDto;
import com.example.java_lab5.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
//@RequestMapping("/api/customer")
//@EnableMethodSecurity(jsr250Enabled = true)
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/api/customer/create")
    public ResponseEntity createCustomer(CustomerDto customerDto, UriComponentsBuilder uriBuilder){
        Customer customer = new Customer();
        customer.setAge(customerDto.getAge());
        customer.setName(customerDto.getName());
        var result = customerService.save(customer);
        URI locationOfNewProduct= UriComponentsBuilder
                .fromPath("/api/customer/{id}")
                .buildAndExpand(result.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewProduct).build();
    }

    @GetMapping("/api/customer/get/{id}")
    public ResponseEntity getCustomerById(@PathVariable int id){
        return ResponseEntity.ok(customerService.findOne(id));
    }
}
