package com.example.demoJPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    Integer id;
    Date order_date;
    Date shipped_date;
    String status;
    String comments;
    Integer customer_id;

}
