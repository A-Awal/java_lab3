package com.example.java_lab5.application;

import com.example.java_lab5.application.baseServices.BaseService;
import com.example.java_lab5.domain.Customer;
import com.example.java_lab5.persistence.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Customer, Integer> {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
