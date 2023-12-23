package com.example.repository;

import com.example.entity.MenuFood;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuFoodRepository extends CrudRepository<MenuFood,String> {

    @Query(value = "select * from menu_food",nativeQuery = true)
    List<MenuFood> getAll();

    @Query(value = "select * from menu_food where menu_no like ?1",nativeQuery = true)
    MenuFood findSingle(String food_no);

    /*
    筛选
     */
    @Query(value = "select * from menu_food where menu_feature not like ?1",nativeQuery = true)
    List<MenuFood> filter(String menu_feature);

}
