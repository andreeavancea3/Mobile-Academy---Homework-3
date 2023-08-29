package com.example.demoJPA.model;

import javax.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Customers customer;
    @ManyToOne
    private Products product;
    private String product_code;
    private int quantity;
    private Double priceEach;
}
