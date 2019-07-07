package com.sbeam.service.impl;

import com.sbeam.dao.mappering.SearchGamesDao;
import com.sbeam.dao.pojo.Games;
import com.sbeam.service.SearchGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchGamesServiceImpl implements SearchGamesService {
    @Autowired(required = false)
    SearchGamesDao searchGamesDao;

    /**
     * 游戏查找
     * @param gameName
     * @return
     */
    @Override
    public List<Games> secrchGames(String gameName) {
        List<Games> games = searchGamesDao.secrchGames(gameName);
        return games;
    }

    /**
     * 单个游戏详情展示
     * @param id
     * @return
     */
    @Override
    public Games getGameById(int id) {
        Games game = searchGamesDao.getGameById(id);
        return game;
    }
}
