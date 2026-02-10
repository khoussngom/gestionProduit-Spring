package com.crudProduct.CrudProduct.services;

import com.crudProduct.CrudProduct.dtos.ProductDto;

import java.util.List;

public interface ProductInterface {
        ProductDto createProduct(ProductDto productDto);
        List<ProductDto> getAllProducts();
        List<ProductDto> getProductsByCategory(String category);
        ProductDto getProductByNom(String nom);
        ProductDto updateProduct(String nom, ProductDto productDto);
        void deleteProduct(Long id);
}
