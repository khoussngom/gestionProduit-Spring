package com.crudProduct.CrudProduct.services;

import com.crudProduct.CrudProduct.dtos.ProductDto;
import com.crudProduct.CrudProduct.entites.Product;
import com.crudProduct.CrudProduct.enums.ProductCategory;
import com.crudProduct.CrudProduct.mappers.ProductMappers;
import com.crudProduct.CrudProduct.repositories.ProductRepository;
import com.crudProduct.CrudProduct.services.ProductInterface;
import com.crudProduct.CrudProduct.exceptions.RessourceNotFoundException;
import com.crudProduct.CrudProduct.exceptions.InvalidCategoryException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductInterface {

    private final ProductRepository repository;

    private final ProductMappers mapper;


    public ProductService(ProductRepository repository, ProductMappers mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product entity = mapper.toEntity(productDto);
        Product saved = repository.save(entity);
        return mapper.toDto(saved);
    }


    @Override
    public List<ProductDto> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<ProductDto> getProductsByCategory(String category) {
        ProductCategory catEnum;
        try {
            catEnum = ProductCategory.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidCategoryException("{product.invalidCategory}" + category);
        }

        return repository.findByCategory(catEnum)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductByNom(String nom) {
        Product product = repository.findByNom(nom)
                .orElseThrow(() -> new RessourceNotFoundException("{product.notFound}" + nom));

        return mapper.toDto(product);
    }

    @Override
    public ProductDto updateProduct(String name, ProductDto productDto) {
        Product existing = repository.findByNom(name)
                .orElseThrow(() -> new RessourceNotFoundException("{product.notFound}" + name));


        existing.setNom(productDto.getNom());
        existing.setDescription(productDto.getDescription());
        existing.setPrix(productDto.getPrix());
        existing.setCategory(productDto.getCategory());

        Product updated = repository.save(existing);
        return mapper.toDto(updated);
    }


    @Override
    public void deleteProduct(Long id) {
        Product existing = repository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("{product.notFound}" + id));
        repository.delete(existing);
    }
}
