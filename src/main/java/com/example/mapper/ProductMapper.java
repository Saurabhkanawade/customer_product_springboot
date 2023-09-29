package com.example.mapper;

import com.example.dto.ProductDto;
import com.example.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {



    ProductEntity dtoToEntity(ProductDto productDto);


    ProductDto entityToDto(ProductEntity productEntity);

    List<ProductDto> entitysToDtos(List<ProductEntity> productEntity);


}
