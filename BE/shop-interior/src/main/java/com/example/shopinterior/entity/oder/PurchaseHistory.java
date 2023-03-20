package com.example.shopinterior.entity.oder;

import com.example.shopinterior.entity.product.Product;
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
    private int idPurchaseHistory;
    private int quantity;
    @ManyToOne
    private Oder oder;
    @ManyToOne
    private Product product;

}
