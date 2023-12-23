package com.example.controller;

import com.example.entity.Log;
import com.example.entity.UserBase;
import com.example.services.LogServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogControl {
    private final LogServices logServices;

    @GetMapping("getall")
    public List<Log> getAll(@RequestBody UserBase userBase){
       return logServices.findAll(userBase);
    }

    @GetMapping("find")
    public  Log getSingle(@RequestParam String user_name,@RequestParam String select_name){
        return logServices.getSingleLog(user_name, select_name);
    }

    @PostMapping("insert")
    public String insert(@RequestParam String user_name,@RequestParam String select_no,@RequestParam String select_name){
        if (logServices.insert(user_name, select_no, select_name))
            return "记录已增加";
        else
            return "记录增加失败";
    }

    @DeleteMapping("delete")
    public String delete(@RequestBody Log log){
        if (logServices.delete(log)){
            return "删除成功";
        }else
            return "删除失败";
    }

}
