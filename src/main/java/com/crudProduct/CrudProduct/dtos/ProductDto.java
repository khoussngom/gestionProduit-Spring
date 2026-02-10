package com.crudProduct.CrudProduct.dtos;

import com.crudProduct.CrudProduct.enums.ProductCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @NotNull(message = "{product.name.notnull}")
    private String nom;

    @NotNull(message = "{product.description.notnull}")
    private String description;

    @NotNull(message = "{product.prix.notnull}")
    @Positive(message = "{produc.prix.positive}")
    private Double prix;

    @NotNull(message = "{product.category.notnull}")
    private ProductCategory category;
}