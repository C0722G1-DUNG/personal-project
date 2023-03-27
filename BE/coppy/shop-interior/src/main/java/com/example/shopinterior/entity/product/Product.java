package com.example.shopinterior.entity.product;
import com.example.shopinterior.entity.cart.Cart;
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
    private Integer idProduct;
    private String nameProduct;
    @Column(length = 100000000)
    private String description;
    private boolean flagDelete = false;
    private Double price;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<Image> imageSet;
    @OneToMany(mappedBy = "product")
    private Set<PurchaseHistory> purchaseHistorySet;
    @OneToMany(mappedBy = "product")
    private Set<Cart> carts;

    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Set<Image> getImageSet() {
        return imageSet;
    }

    public Set<PurchaseHistory> getPurchaseHistorySet() {
        return purchaseHistorySet;
    }
}
