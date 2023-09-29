package com.example.service;

import com.example.dto.CustomerDto;
import com.example.dto.ProductDto;
import com.example.entity.CustomerEntity;
import com.example.entity.ProductEntity;
import com.example.mapper.CustomerMapper;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    //    get all customers from the database
    public List<CustomerDto> getAllCustomers() {
        return customerMapper.entitysToDtos(customerRepository.findAll());
    }

    //    add new customer into the database table
    public CustomerEntity addCustomers(CustomerDto customerDto) {
        return customerRepository.save(customerMapper.dtoToEntity(customerDto));
    }

    //   updating the customer by id
    public ResponseEntity<CustomerEntity> updateCustomerById(Integer id, CustomerDto customerDto) {
        return new ResponseEntity<>(customerRepository.save(customerMapper.dtoToEntity(customerDto)), HttpStatus.OK);
    }


    //   deleting the Customer by id from the database
    public ResponseEntity deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
