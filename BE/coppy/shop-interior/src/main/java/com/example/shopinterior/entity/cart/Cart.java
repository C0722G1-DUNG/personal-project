package com.example.shopinterior.entity.cart;

import com.example.shopinterior.entity.account.User;
import com.example.shopinterior.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCart;
    private int quantity;
    @JsonManagedReference
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
}
