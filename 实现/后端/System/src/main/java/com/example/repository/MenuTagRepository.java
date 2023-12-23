package com.example.repository;

import com.example.entity.MenuTag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuTagRepository extends CrudRepository<MenuTag,String> {
    /*
    拉取所有
     */
    @Query(value = "select * from menu_tag",nativeQuery = true)
    List<MenuTag> getALL();

    /*
    查找一个
     */
    @Query(value = "select * from menu_tag where food_no like ?1",nativeQuery = true)
    public MenuTag getSingle(String food_no);
}
