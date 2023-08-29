package com.example.demoJPA.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customers {
    @Id
    @GeneratedValue
    Integer id;
    String username;
    String last_name;
    String first_name;
    String phone;
    String address;
    String city;
    String postalCode;
    String country;
}

