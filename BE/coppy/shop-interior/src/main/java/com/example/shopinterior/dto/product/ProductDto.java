package com.example.shopinterior.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String nameProduct;
    private String description;
    private Double price;
    private ImageDto[] imageDto;
}
