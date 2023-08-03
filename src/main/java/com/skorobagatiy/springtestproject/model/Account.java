package com.skorobagatiy.springtestproject.model;

import com.skorobagatiy.springtestproject.enums.AccountType;
import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String accountType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // todo Improve code with currency (!!!)
    //private Double currency;
    private Double amount;

}
