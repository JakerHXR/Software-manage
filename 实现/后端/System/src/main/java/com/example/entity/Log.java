package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "log")
public class Log {
    @Column(name = "user_name")
    private String user_name;
    @Id
    @Column(name = "select_no")
    private String select_no;
    @Column(name = "select_name")
    private String select_name;
}
