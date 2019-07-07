package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.Games;

import java.util.List;

/**
 * 游戏搜索
 */
public interface SearchGamesDao {
    /**
     * 游戏查询
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
