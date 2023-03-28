package com.example.shopinterior.entity.product;
import com.example.shopinterior.entity.cart.Cart;
import com.example.shopinterior.entity.oder.PurchaseHistory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    private String nameProduct;
    @Column(length = 100000000)
    private String description;
    private boolean flagDelete = false;
    private Double price;
    private int quantity;
    @JsonManagedReference
    @ManyToOne
    private Category category;
    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private Set<Image> imageSet;
    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private Set<PurchaseHistory> purchaseHistorySet;
    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private Set<Cart> carts;
}
