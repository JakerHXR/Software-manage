package com.example.controller;

import com.example.entity.UserBase;
import com.example.services.UserBaseServices;
import com.example.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userbase")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserBaseControl {
    private final UserBaseServices userBaseServices;
    private final UserServices userServices;

    @GetMapping("getall")
    public List<UserBase> getAll(){
        return userBaseServices.getAllUserBase();
    }

    @GetMapping("find")
    public UserBase find(@RequestBody UserBase userBase){
        return userBaseServices.findUserBase(userBase);
    }

    @PostMapping("sign/in/up")
    public String signInUserBase(@RequestParam String user_name, @RequestParam String user_pwd){
        UserBase userBase = new UserBase(user_name,user_pwd);
        if (!userBaseServices.isExist(userBase)){
            if(userBaseServices.insertUserBase(userBase) && userServices.insertUserByUser_name(user_name))
                return "注册成功";
            else
                return "注册失败";
        }
        else
            return "已存在账号";
    }

    @GetMapping("pwd")
    public String findUserPassword(@RequestBody UserBase userBase){
        if (!userBaseServices.isExist(userBase))
            return "未找到账号";
        else {
            UserBase temp = userBaseServices.findUserBase(userBase);
            return "密码为:"+temp.getUser_pwd();
        }
    }

    @PutMapping("update")
    public String updateUserBase(@RequestBody UserBase userBase){
        if (!userBaseServices.isExist(userBase)){
            return "未找到账号";
        }else {
           if (userBaseServices.updateUserBase(userBase))
               return "更新成功";
           else
               return "更新失败";
        }
    }

   @DeleteMapping("delete")
    public String deleteUserBase(@RequestBody UserBase userBase){
        if (userBaseServices.deleteUserBase(userBase))
            return "删除成功";
        else
            return "删除失败";
   }
}
