package com.example.java_lab5.persistence;

import com.example.java_lab5.domain.Purchases;
//import com.example.java_lab5.persistence.baseRepository.BaseRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesRepository extends CrudRepository<Purchases, Integer> {
}
