package com.example.vts2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "usr")
public class User {
    @Id
    @Column(name = "login")
    String login;
    @Column(name = "role")
    String role;
    @Column(name = "password")
    String password;
    @ElementCollection
    @CollectionTable(name = "usrcars", joinColumns = @JoinColumn(name = "login"))
    @Column(name = "car")
    List<String> cars;
}
