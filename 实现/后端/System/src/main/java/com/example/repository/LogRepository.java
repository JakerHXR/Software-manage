package com.example.repository;

import com.example.entity.Log;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<Log,String> {

    //查找所有记录
    @Query(value = "select * from log where user_name like ?1",nativeQuery = true)
    List<Log> getALL(String user_name);

    //是否存在当前记录
    @Query(value = "select * from log where user_name like ?1 and select_no like ?2",nativeQuery = true)
    Log getLog(String user_name,String select_no);

    /*
    查找单个记录
    @param 用户名、菜名
     */
    @Query(value = "select * from log where user_name like ?1 and select_name like ?2",nativeQuery = true)
    Log getSingleLog(String user_name,String select_name);

    /*
    删除
    @param user_name,select_name
     */
    @Modifying
    @Query(value = "delete from log where user_name like ?1 and select_name like ?2",nativeQuery = true)
    void delete(String user_name,String select_name);
}
