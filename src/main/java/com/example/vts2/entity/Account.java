package com.example.vts2.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "accountID")
    String accountID;
    @Column(name = "password")
    String password;
    @Column(name = "creationtime")
    int creationtime;
    @Column(name = "lastlogintime")
    int lastlogintime;
}
