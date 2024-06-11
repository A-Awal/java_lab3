package com.example.java_lab5.application.baseServices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public class BaseService<E, T> {
    private final CrudRepository<E, T> repository;

    public BaseService(CrudRepository<E, T> repository) {
        this.repository = repository;
    }

    public E save(E entity) {
        return repository.save(entity);
    }
    public E update(E entity) {
        return repository.save(entity);
    }
    public void delete(E entity) {
        repository.delete(entity);
    }
    public E findOne(T id) {
        return repository.findById(id).orElse(null);
    }
//    public Page<E> GetPaginated(Pageable pageable) {
//       return repository.findAll(pageable);
//    }
}
