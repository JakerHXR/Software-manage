package com.example.services;

import com.example.entity.User;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServices {
    private final UserRepository userRepository;

    /*
    查询是否存在
     */
    public boolean isExist(User user){
        return userRepository.findByUser_name(user.getUser_name()) != null;
    }

    /*
    查找用户信息
     */
    public User findUser(User user){
        return userRepository.findByUser_name(user.getUser_name());
    }

    /*
    增加用户信息（增加用户名）
    在注册时添加
     */
    public boolean insertUserByUser_name(String userName){
        User user = new User();
        user.setUser_name(userName);
        userRepository.save(user);
        return true;
    }

    /*
    删除用户信息
     */
    public boolean deleteUser(User user){
        userRepository.delete(user);
        return true;
    }

    /*
    更新用户信息
     */
    public boolean updateUser(User user){
        userRepository.save(user);
        return true;
    }


}
