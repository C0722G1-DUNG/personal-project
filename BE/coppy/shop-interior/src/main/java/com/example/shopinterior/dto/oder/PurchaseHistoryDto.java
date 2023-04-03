package com.example.shopinterior.dto.oder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseHistoryDto {
    private Integer idCart;
    private int quantity;
    private Integer idProduct;
}
