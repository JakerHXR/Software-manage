package com.example.services;

import com.example.entity.MenuFood;
import com.example.repository.MenuFoodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuFoodServices {
    private final MenuFoodRepository menuFoodRepository;

    /*
    拉取所有
     */
    public List<MenuFood> getAll() {
        return menuFoodRepository.getAll();
    }

    /*
    查找一个
     */
    public MenuFood getSingle(MenuFood menuFood){
        return menuFoodRepository.findSingle(menuFood.getMenu_no());
    }

    /*
    增加一条
     */
    public boolean insert(MenuFood menuFood){
        menuFoodRepository.save(menuFood);
        return true;
    }

    /*
    删除一条
     */
    public boolean delete(MenuFood menuFood){
        menuFoodRepository.delete(menuFood);
        return true;
    }

    /*
    更新一条
     */
    public boolean update(MenuFood menuFood){
        if (menuFoodRepository.findSingle(menuFood.getMenu_no()) == null){
            return false;
        }
        else {
            menuFoodRepository.save(menuFood);
            return true;
        }
    }

    /*
    筛选
     */
    public List<MenuFood> filter(String menu_feature){
        return menuFoodRepository.filter(menu_feature);
    }
}
