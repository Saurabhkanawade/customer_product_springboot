package com.example.service;

import com.example.mapper.ProductMapper;
import com.example.dto.ProductDto;
import com.example.entity.ProductEntity;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    //    getting all products from the database
    public List<ProductDto> getProducts() {
        return productMapper.entitysToDtos(productRepository.findAll());
    }

    //   get product by id from the database
    public ProductDto getProductById(Integer id) {
        return productMapper.entityToDto(productRepository.getOne(id));
    }

    //    Add new product into the database
    public ResponseEntity<ProductEntity> addProducts(ProductDto productDto) {
        return new ResponseEntity<>(productRepository.save(productMapper.dtoToEntity(productDto))
                , HttpStatus.CREATED);
    }

    //   updating the product by id
    public ResponseEntity<ProductEntity> updateProductById(Integer id, ProductDto productDto) {
        return new ResponseEntity<>(productRepository.save(productMapper.dtoToEntity(productDto)), HttpStatus.OK);
    }


    //   deleting the product by id from the database
    public ResponseEntity deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
