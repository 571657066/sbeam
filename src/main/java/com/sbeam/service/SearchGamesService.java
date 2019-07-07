package com.sbeam.service;

import com.sbeam.dao.pojo.Games;

import java.util.List;

public interface SearchGamesService {

    /**
     *游戏查找
     * @param gameName
     * @return
     */
    public List<Games> secrchGames(String gameName);

    /**
     * 单个游戏详情展示
     * @param id
     * @return
     */
    public Games getGameById(int id);
}
