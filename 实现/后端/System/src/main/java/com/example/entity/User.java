package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "user")
@Entity
public class User {
    @Id
    @Column(name = "user_name")
    private String user_name;

    @Column(name = "name")
    private String name;
    @Column(name = "id")
    private String id;
    @Column(name = "age")
    private int age;
    @Column(name = "address")
    private String address;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }



}
