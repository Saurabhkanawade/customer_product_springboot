package com.example.mapper;

import com.example.dto.CustomerDto;
import com.example.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CustomerMapper {



    @Mapping(source = "productDto",target = "productEntity")
    CustomerEntity dtoToEntity(CustomerDto customerDto);

    @InheritInverseConfiguration
    CustomerDto enityToDto(CustomerEntity customerEntity);

    List<CustomerDto> entitysToDtos(List<CustomerEntity> customerEntity);
}
