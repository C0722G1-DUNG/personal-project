package com.example.shopinterior.entity.oder;

import com.example.shopinterior.entity.account.Account;
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
    private int idOder;
    private String flagDelete;
    private String orderDate;
    @ManyToOne
    private Payment payment;
    @ManyToOne
    private Account account;
    @OneToMany(mappedBy = "oder")
    private Set<PurchaseHistory> purchaseHistorySet;
}
