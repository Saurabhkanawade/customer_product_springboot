package com.example.controller;

import com.example.dto.ProductDto;
import com.example.entity.ProductEntity;

import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //get all the products from the database
    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

//  get the product by id

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable(name = "id") Integer id){
        return productService.getProductById(id);
    }

    //  add new products in the database
    @PostMapping("/products")
    public ResponseEntity<ProductEntity> addProducts(@RequestBody ProductDto productDto) {
        productService.addProducts(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //    update the product by id
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductEntity> updateProductById(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        productService.updateProductById(id, productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //    delete the product by id
    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProductById(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.OK);
    }


}
