package com.example.demoJPA.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostalDetailsUserDTO {
    private String phone;
    private String address;
    private String city;
}
