package com.example.controller;

import com.example.entity.User;
import com.example.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserControl {
    private final UserServices userServices;

    @GetMapping("find")
    public User findUser(@RequestBody User user) {
        return userServices.findUser(user);
    }

    @PutMapping("update")
    public String updateUser(@RequestBody User user){
        if (userServices.isExist(user)){
            if (userServices.updateUser(user)){
                return "更新成功";
            }else{
                return "更新失败";
            }
        }else
            return "不存在此用户";
    }

    @DeleteMapping("delete")
    public String deleteUser(@RequestBody User user){
        if (userServices.deleteUser(user))
            return "删除成功";
        else
            return "删除失败";
    }
}
