package com.crudProduct.CrudProduct.mappers;

import com.crudProduct.CrudProduct.dtos.ProductDto;
import com.crudProduct.CrudProduct.entites.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ProductMappers {

        ProductMappers INSTANCE = Mappers.getMapper(ProductMappers.class);

        Product toEntity(ProductDto productDTO);

        ProductDto toDto(Product product);
    }

