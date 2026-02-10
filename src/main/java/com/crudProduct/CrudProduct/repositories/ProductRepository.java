package com.crudProduct.CrudProduct.repositories;

import com.crudProduct.CrudProduct.entites.Product;
import com.crudProduct.CrudProduct.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNom(String nom);
    List<Product> findByCategory(ProductCategory category);
}
