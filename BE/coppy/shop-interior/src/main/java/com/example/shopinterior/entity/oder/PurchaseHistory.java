package com.example.shopinterior.entity.oder;

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
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPurchaseHistory;
    private int quantity;
    @JsonManagedReference
    @ManyToOne
    private Oder oder;
    @JsonManagedReference
    @ManyToOne
    private Product product;
}
