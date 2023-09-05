package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name ="Accounts")
public class Account implements Serializable {
    @Id
    String username;
    String password;
    String fullname;
    String email;
    String photo;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Order> orders;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Authority> authorities;
}
