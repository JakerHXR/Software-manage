package com.example.repository;

import com.example.entity.Administer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministerRepository extends CrudRepository<Administer,String> {
    /*无法使用
    @Query(value = "select admin.admin_name,admin.admin_pwd from Administer admin where admin.admin_name like ?1")
    boolean existsByAdmin_name(String admin_name);
     */

    //查找管理员
    @Query(value = "select * from administer where administer.admin_name like ?1",nativeQuery = true)
    Administer findAdministerByAdmin_name( String admin_name);

    @Query(value = "select * from administer",nativeQuery = true)
    List<Administer> getAll();
}
