package com.example.demoJPA.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customers {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String last_name;
    private  String first_name;
    private String phone;
    private  String address;
    private String city;
    private String postalCode;
    private String country;

    @OneToMany(mappedBy = "customers")
    private List<Orders> orders;
}

