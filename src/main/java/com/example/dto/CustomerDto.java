package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @Id
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;


    private ProductDto productDto;
}
