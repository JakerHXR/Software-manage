package com.example.controller;

import com.example.entity.Administer;
import com.example.services.AdministerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdministerControl {
    private final AdministerServices administerServices;

    /*
    注册管理员账户
    @param administer
    @return string
     */
    @PostMapping("sign/in/up")
    public String signInUp(@RequestBody Administer administer){
        if (administerServices.isExist(administer)){
            return "该账号已注册";
        }else{
            if(administerServices.insertAdminister(administer))
                return "注册成功";
            else
                return "注册失败";
        }
    }

    @PostMapping("pwd")
    public String backPwd(@RequestBody Administer administer){
        if (administerServices.isExist(administer)){
            Administer temp = administerServices.findAdminister(administer);
            return "密码为："+temp.getAdmin_pwd();
        }else{
            return "找回密码账号不存在";
        }
    }

    @PutMapping ("update")
    public String update(@RequestBody Administer administrator){
        if (administerServices.updateAdminister(administrator)){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

    @DeleteMapping("delete")
    public String delete(@RequestBody Administer administrator){
        if (administerServices.deleteAdminister(administrator)){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @GetMapping("/getall")
    public List<Administer> getall(){
        return administerServices.getAll();
    }

    @GetMapping("/find")
    public Administer find(@RequestBody Administer administer){
        return administerServices.findAdminister(administer);
    }
}
