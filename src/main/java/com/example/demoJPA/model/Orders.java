package com.example.demoJPA.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue
    Integer id;
    Date order_date;
    Date shipped_date;
    String status;
    String comments;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customers customer;

    @OneToMany
    private List<Products> products = new ArrayList<>();

}
