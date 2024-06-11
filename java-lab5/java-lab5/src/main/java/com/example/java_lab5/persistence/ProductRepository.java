package com.example.java_lab5.persistence;

import com.example.java_lab5.domain.Product;
//import com.example.java_lab5.persistence.baseRepository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
