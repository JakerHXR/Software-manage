package com.example.repository;


import com.example.entity.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBaseRepository extends CrudRepository<UserBase,String> {

    @Query(value = "select * from user_base where user_base.user_name like ?1",nativeQuery = true)
    UserBase findByUser_name(String user_name);

    @Query(value = "select * from user_base ",nativeQuery = true)
    List<UserBase> getAll();
}
