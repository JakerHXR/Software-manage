package com.example.services;

import com.example.entity.UserBase;
import com.example.repository.UserBaseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserBaseServices {
    private final UserBaseRepository userBaseRepository;

    /*
    查找是否存在
    @param userbase
    @return boolean
     */
    public boolean isExist(UserBase userBase){
        return userBaseRepository.findByUser_name(userBase.getUser_name()) != null;
    }


    /*
    查找基本用户
    @param userbase
    @return userbase
     */
    public UserBase findUserBase(UserBase userBase){
        return userBaseRepository.findByUser_name(userBase.getUser_name());
    }

    /*
    增加基础用户
     */
    public boolean insertUserBase(UserBase userBase){
        userBaseRepository.save(userBase);
        return true;
    }

    /*
    删除用户
     */
    public boolean deleteUserBase(UserBase userBase){
        userBaseRepository.delete(userBase);
        return true;
    }

    /*
    更新
     */
    public boolean updateUserBase(UserBase userBase){
        if (!isExist(userBase))
            return false;
        else{
            userBaseRepository.save(userBase);
            return true;
        }
    }

    /*
    拉取所有
     */
    public List<UserBase> getAllUserBase(){
        return userBaseRepository.getAll();
    }
}
