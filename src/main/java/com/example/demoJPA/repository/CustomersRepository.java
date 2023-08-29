package com.example.demoJPA.repository;

import com.example.demoJPA.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    Customers findByUsername(String username);
}
