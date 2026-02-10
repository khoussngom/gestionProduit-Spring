package com.crudProduct.CrudProduct.controllers;


import com.crudProduct.CrudProduct.dtos.ProductDto;
import com.crudProduct.CrudProduct.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDto addProduct(@RequestBody @Valid ProductDto product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{category}")
    public List<ProductDto> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/name/{nom}")
    public ProductDto getProductByNom(@PathVariable String nom) {
        return productService.getProductByNom(nom);
    }

    @PutMapping("/name/{nom}")
    public ProductDto updateProduct(@PathVariable String nom, @RequestBody @Valid ProductDto productDto) {
        return productService.updateProduct(nom, productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
