package com.sbeam.service.impl;

import com.sbeam.dao.mappering.GamerMapper;
import com.sbeam.dao.pojo.Gamer;
import com.sbeam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    GamerMapper gamerMapper;

    @Override
    public Gamer Login(Gamer gamer) {
        gamer = gamerMapper.selectOneUser(gamer);
        //gamer如果为空 即账号或密码错误
        return gamer;
    }

    @Override
    public boolean Register(Gamer gamer) {
        Gamer gamer1 = gamerMapper.selectOneUser(gamer);
        if (gamer1==null){
            int i = gamerMapper.insertOneUser(gamer);
            if(i>0){
                return true;
            }
        }
            return false;


    }


}
