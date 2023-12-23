package com.example.services;

import com.example.entity.Administer;
import com.example.repository.AdministerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdministerServices {
    private final AdministerRepository administerRepository;


    /*
    管理员是否存在
    @param administer
    @return boolean
     */
    public boolean isExist(Administer administer){
//        return administerRepository.existsByAdmin_name(administer.getAdmin_name());
        return administerRepository.findAdministerByAdmin_name(administer.getAdmin_name()) != null;
    }

    /*
    查找管理员、
    @param administer
    @return administer
     */
    public Administer findAdminister(Administer administer){
        return administerRepository.findAdministerByAdmin_name(administer.getAdmin_name());
    }

    /*
    增加管理员
    @param administer
    @return boolean
     */
    public boolean insertAdminister(Administer administer){
        administerRepository.save(administer);
        return true;
    }

    /*
    删除管理员(不可删除最终管理员（暂定）)
    @param administer
    @return boolean
     */
    public boolean deleteAdminister(Administer administer){
        administerRepository.delete(administer);
        return true;
    }

    /*
    修改管理员
    @param administer
    @return boolean
     */
    public boolean updateAdminister(Administer administer){
        if (!isExist(administer)){
            return false;
        }else {
            administerRepository.save(administer);
            return true;
        }
    }


    /*
    拉取所有管理员
    @param null
    @return list<administer>
     */
    public List<Administer> getAll(){
        return administerRepository.getAll();
    }
}
