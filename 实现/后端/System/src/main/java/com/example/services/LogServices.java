package com.example.services;

import com.example.entity.Log;
import com.example.entity.UserBase;
import com.example.repository.LogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogServices {
    private final LogRepository logRepository;

    /*
    查找所有记录
     */
    public List<Log> findAll(UserBase userBase){
        return logRepository.getALL(userBase.getUser_name());
    }

    /*
    查找单个记录
     */
    public Log getSingleLog(String usrName, String select_name){
        return logRepository.getSingleLog(usrName, select_name);
    }

    /*
    增加记录
     */
    public boolean insert(String user_name, String select_no,String select_name){
        Log log = new Log();
        log.setUser_name(user_name);
        log.setSelect_no(select_no);
        log.setSelect_name(select_name);
        if (logRepository.getLog(user_name,select_name)!=null)
            return false;
        else {
            logRepository.save(log);
            return true;
        }
    }

    /*
    删除记录
     */
    public boolean delete(Log log) {
        logRepository.delete(log.getUser_name(),log.getSelect_name());
        return true;
    }
}
