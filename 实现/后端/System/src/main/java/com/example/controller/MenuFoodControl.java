package com.example.controller;

import com.example.entity.MenuFood;
import com.example.services.MenuFoodServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menufood")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuFoodControl {
    private  final MenuFoodServices menuFoodServices;

    /*
       拉取所有
     */
    @GetMapping("getall")
    public List<MenuFood> getAll() {
        return menuFoodServices.getAll();
    }

    /*
    查询一个
     */
    @GetMapping("find")
    public MenuFood getSingle(@RequestBody MenuFood menuFood){
        return menuFoodServices.getSingle(menuFood);
    }

    /*
    筛选
     */
    @GetMapping("filter")
    public List<MenuFood> filter(@RequestParam String menu_feature){
        return menuFoodServices.filter(menu_feature);
    }

    /*
    增加一条
     */
    @PostMapping("insert")
    public String insert(@RequestBody MenuFood menuFood){
        if (menuFoodServices.getSingle(menuFood) == null){
            if (menuFoodServices.insert(menuFood)){
                return "增加一条记录";
            }else
                return "增加失败";
        }
        else
            return "已存在此记录";
    }

    /*
    删除一条
     */
    @DeleteMapping("delete")
    public String delete(@RequestBody MenuFood menuFood){
        if (menuFoodServices.delete(menuFood)){
            return "删除一条记录";
        }else
            return "删除失败";
    }

    /*
    更新
     */
    @PutMapping("update")
    public String update(@RequestBody MenuFood menuFood){
        if (menuFoodServices.getSingle(menuFood) != null){
            if (menuFoodServices.update(menuFood)){
                return "更新成功";
            }else
                return "更新失败";
        }
        else
            return "不存在此记录";
    }
}
