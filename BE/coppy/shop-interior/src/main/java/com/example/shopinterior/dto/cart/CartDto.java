package com.example.shopinterior.dto.cart;

import com.example.shopinterior.dto.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Integer idCart;
    private int quantity;
    private ProductDto productDto;
    private Integer id;

}
