package com.example.demoJPA.repository;

import com.example.demoJPA.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, String> {
    Products findByCode(Long code);
}
