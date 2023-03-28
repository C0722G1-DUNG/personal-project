package com.example.shopinterior.entity.oder;

import com.example.shopinterior.entity.account.User;
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
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOder;
    private String flagDelete;
    private String orderDate;
    private String paymentMethod;
    @JsonManagedReference
    @ManyToOne
    private User user;
    @JsonBackReference
    @OneToMany(mappedBy = "oder")
    private Set<PurchaseHistory> purchaseHistorySet;
}
