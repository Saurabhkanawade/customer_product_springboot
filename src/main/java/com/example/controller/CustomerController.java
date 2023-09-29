package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.ProductDto;
import com.example.entity.CustomerEntity;
import com.example.entity.ProductEntity;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customers")
    public CustomerEntity addCustomers(@RequestBody CustomerDto customerDto) {
        return customerService.addCustomers(customerDto);
    }

    //    update the product by id
    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerEntity> updateCustomerById(@PathVariable Integer id,
                                                        @RequestBody CustomerDto customerDto) {
        customerService.updateCustomerById(id, customerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //    delete the product by id
    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable Integer id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
