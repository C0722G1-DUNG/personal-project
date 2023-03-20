package com.example.shopinterior.entity.product;
import com.example.shopinterior.entity.oder.PurchaseHistory;
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
    private int idProduct;
    private String nameProduct;
    private String description;
    private boolean flagDelete = false;
    private Double price;
    private String avatar;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<Image> imageSet;
    @OneToMany(mappedBy = "product")
    private Set<PurchaseHistory> purchaseHistorySet;
}
