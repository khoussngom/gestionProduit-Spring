package com.crudProduct.CrudProduct.entites;

import com.crudProduct.CrudProduct.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "products",
        uniqueConstraints = {
                                @UniqueConstraint(columnNames = "nom")
                             })
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    
    private String description;
    private double prix;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory category;

}
