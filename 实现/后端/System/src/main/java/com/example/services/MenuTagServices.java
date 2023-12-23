package com.example.services;

import com.example.entity.MenuTag;
import com.example.repository.MenuTagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuTagServices {
    private final MenuTagRepository menuTagRepository;

    /*
    拉取所有
     */
    public List<MenuTag> getAll(){
        return menuTagRepository.getALL();
    }

    /*
    查找一个
     */
    public MenuTag getSingle(MenuTag menuTag){
        return menuTagRepository.getSingle(menuTag.getFood_no());
    }

    /*
    挑选tag显示菜单
     */
    public List<MenuTag> select(String food_tag){
        return menuTagRepository.select(food_tag);
    }

    /*
    增加一个
     */
    public boolean insert(MenuTag menuTag){
        menuTagRepository.save(menuTag);
        return true;
    }

    /*
    删除一个
     */
    public boolean delete(MenuTag menuTag){
        menuTagRepository.delete(menuTag);
        return true;
    }

    /*
    更新一个
     */
    public boolean update(MenuTag menuTag){
        if (menuTagRepository.getSingle(menuTag.getFood_no()) == null){
            return false;
        }else{
            menuTagRepository.save(menuTag);
            return true;
        }
    }
}
