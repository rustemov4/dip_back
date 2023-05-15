package com.example.vts2.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "accountID")
    String accountID;
    @Column(name = "password")
    String password;

}
