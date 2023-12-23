package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "menu_food")
public class MenuFood {
    @Id
    @Column(name = "menu_no")
    private String menu_no;
    @Column(name = "admin_name")
    private String admin_name;
    @Column(name = "menu_name")
    private String menu_name;
    @Column(name = "menu_feature")
    private String menu_feature;

    public MenuFood(String menu_no, String menu_name) {
        this.menu_no = menu_no;
        this.menu_name = menu_name;
    }

    public MenuFood(String menu_no, String menu_name, String menu_feature) {
        this.menu_no = menu_no;
        this.menu_name = menu_name;
        this.menu_feature = menu_feature;
    }
}
