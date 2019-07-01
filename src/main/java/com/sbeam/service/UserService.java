package com.sbeam.service;

import com.sbeam.dao.pojo.Gamer;

public interface UserService {
    /**
     * 根据gamer查询这个gamer是否存在
     * @param gamer
     * @return
     */
    Gamer Login(Gamer gamer);

    boolean Register(Gamer gamer);
}
