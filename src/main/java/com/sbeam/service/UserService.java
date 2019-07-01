package com.sbeam.service;

import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbGame;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    /**
     * 根据gamer查询这个gamer是否存在
     * @param gamer
     * @return
     */
    Gamer Login(Gamer gamer);

    /**
     * 根据gamer添加这个gamer
     * @param gamer
     * @return
     */
    boolean Register(Gamer gamer);

    /**
     * 根据gamer更新gamer
     * @param gamer
     * @return
     */
    boolean Update(Gamer gamer);

    /**
     * 根据用户查找他的愿望单
     * @param gamer
     * @return
     */
    String selectWishGame(Gamer gamer);

    /**
     * 用户向愿望单里添加游戏
     * @param games
     * @return
     */
    boolean addWishGame(Gamer gamer, String games);

}
