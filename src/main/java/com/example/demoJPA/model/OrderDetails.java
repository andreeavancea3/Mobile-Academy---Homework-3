package com.example.demoJPA.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private Long product_code;
    private int quantity;
    private Double priceEach;
}

