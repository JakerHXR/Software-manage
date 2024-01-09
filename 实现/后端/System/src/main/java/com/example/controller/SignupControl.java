package com.example.controller;

import com.example.entity.Administer;
import com.example.entity.UserBase;
import com.example.services.AdministerServices;
import com.example.services.UserBaseServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//登录默认页面
@RestController
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SignupControl {
    private final AdministerServices administerServices;
    private final UserBaseServices userBaseServices;

    @PostMapping("signup") //登录页面url  管理员为1  用户为2  其他为0
    public int signup(@RequestParam String id,@RequestParam String pwd){
        if (administerServices.isExist(new Administer(id,pwd))){
            return 1;
        } else if (userBaseServices.isExist(new UserBase(id,pwd))) {
            return 2;
        }else
            return 0;
    }
}
