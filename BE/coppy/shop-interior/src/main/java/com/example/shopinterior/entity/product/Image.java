package com.example.shopinterior.entity.product;

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
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImage;
    private String imageOne;
    private String imageTwo;
    private String imageThree;
    @ManyToOne
    private Product product;

    public Integer getIdImage() {
        return idImage;
    }

    public String getImageOne() {
        return imageOne;
    }

    public String getImageTwo() {
        return imageTwo;
    }

    public String getImageThree() {
        return imageThree;
    }

    public Product getProduct() {
        return product;
    }
}
