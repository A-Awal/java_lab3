package com.example.java_lab5.application;
import com.example.java_lab5.application.baseServices.BaseService;
import com.example.java_lab5.domain.Product;
//import com.example.java_lab5.persistence.baseRepository.BaseRepository;
import com.example.java_lab5.persistence.ProductRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product, Integer> {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
