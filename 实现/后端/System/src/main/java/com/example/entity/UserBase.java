package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_base")
public class UserBase {
    @Id
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "user_pwd")
    private String user_pwd;
}
