package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_tag")
public class MenuTag {
    @Id
    @Column(name = "food_no")
    private String food_no;
    @Column(name = "admin_name")
    private String admin_name;
    @Column(name = "food_name")
    private String food_name;
    @Column(name = "food_tag")
    private String food_tag;

    public MenuTag(String food_no, String food_name) {
        this.food_no = food_no;
        this.food_name = food_name;
    }

    public MenuTag(String food_no, String food_name, String food_tag) {
        this.food_no = food_no;
        this.food_name = food_name;
        this.food_tag = food_tag;
    }
}
