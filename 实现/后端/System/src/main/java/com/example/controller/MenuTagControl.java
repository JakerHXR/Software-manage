package com.example.controller;

import com.example.entity.MenuTag;
import com.example.services.MenuTagServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menutag")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuTagControl {
    private final MenuTagServices menuTagServices;

    /*
    拉取所有
     */
    @GetMapping("getall")
    public List<MenuTag> getAll(){
        return menuTagServices.getAll();
    }

    /*
    查找一个
     */
    @GetMapping("find")
    public MenuTag getSingle(@RequestBody MenuTag menuTag){
        return menuTagServices.getSingle(menuTag);
    }

    /*
    挑选tag 显示菜单
     */
    @GetMapping("select")
    public List<MenuTag> select(@RequestParam String food_tag){
        return menuTagServices.select(food_tag);
    }

    /*
    增加一个
     */
    @PostMapping("insert")
    public String insert(@RequestBody MenuTag menuTag){
        if (menuTagServices.getSingle(menuTag) != null)
            return "已存在此菜单";
        else {
            if (menuTagServices.insert(menuTag)){
                return "已增加一条记录";
            }
            else {
                return "增加失败";
            }
        }
    }

    /*
    删除一个
     */
    @DeleteMapping("delete")
    public String delete(@RequestBody MenuTag menuTag){
        if (menuTagServices.delete(menuTag))
            return "删除成功";
        else
            return "删除失败";
    }

    /*
    更新一条
     */
    @PutMapping("upgrade")
    public String update(@RequestBody MenuTag menuTag){
        if (menuTagServices.getSingle(menuTag) == null)
            return "不存在此记录";
        else {
            if (menuTagServices.update(menuTag))
                return "已更新一条记录";
            else
                return "更新失败";
        }
    }
}
