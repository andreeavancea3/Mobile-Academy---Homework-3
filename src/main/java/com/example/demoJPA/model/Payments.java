package com.example.demoJPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import java.util.Date;

@Entity
public class Payments {
    @Id
    @GeneratedValue
    Integer customer_id;
    Date payment_date;
    Double amount;
}
