package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
    @Query(value = "SELECT * FROM user where user_name = ?1",nativeQuery = true)
    User findByUser_name(String userName);

    @Query(value = "select * from user",nativeQuery = true)
    List<User> getAll();
}
