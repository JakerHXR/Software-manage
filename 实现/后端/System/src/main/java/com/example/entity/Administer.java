package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "administer")
public class Administer {
    @Id
    private String admin_name;


    private String admin_pwd;



    private Date create_date;

    public Administer(String admin_name, String admin_pwd) {

        this.admin_name = admin_name;
        this.admin_pwd = admin_pwd;
    }

    public Administer(String admin_name) {
        this.admin_name = admin_name;
    }
}
