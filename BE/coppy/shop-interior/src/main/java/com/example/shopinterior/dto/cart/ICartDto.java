package com.example.shopinterior.dto.cart;

public interface ICartDto {
    Integer getIdCart();
    int getQuantity();
    int getIdProduct();
    String getNameProduct();
    String getDescription();
    Double getPrice();
    String getImageOne();
    int getTotalCost();
    Integer getId();
}
