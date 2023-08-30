package com.example.demoJPA.repository;

import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
