package com.example.shopinterior.entity.account;

import com.example.shopinterior.entity.oder.Oder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAccount;
    private String emailAccount;
    private String encryptPassword;
    private String nameAccount;
    private String avatarAccount;
    private boolean flagDelete = false;
    private String usernameAccount;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "account")
    private Set<Oder> oderSet;

    public Account(String emailAccount, String encryptPassword, String nameAccount, String usernameAccount) {
        this.emailAccount = emailAccount;
        this.encryptPassword = encryptPassword;
        this.nameAccount = nameAccount;
        this.usernameAccount = usernameAccount;
    }
}
