package com.example.java_lab5.application;

import com.example.java_lab5.application.baseServices.BaseService;
import com.example.java_lab5.domain.Purchases;
import com.example.java_lab5.persistence.PurchasesRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchasesService extends BaseService<Purchases, Integer> {

    public PurchasesService(PurchasesRepository repository) {
        super(repository);
    }
}
