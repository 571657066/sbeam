package com.sbeam.service.impl;

import com.sbeam.dao.mappering.LikeGamesDao;
import com.sbeam.dao.pojo.Games;
import com.sbeam.service.LikeGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LikeGamesServiceImpl implements LikeGamesService {
    @Autowired(required = false)
    LikeGamesDao likeGamesDao;

    //用户点击游戏类型推荐
    @Override
    public List<Games> getGamesByType(String type) {
        List<Games> gamesByType = likeGamesDao.getGamesByType(type);
        return gamesByType;
    }


//用户喜欢游戏类型推荐
    @Override
    public String likeTypes(int id) {
        String games = likeGamesDao.likeTypes(id);

        return games;
    }

    @Override
    public List<Games> likeTypesGet(String[] s) {
        List<Games> games = likeGamesDao.likeTypesGet(s);
        return games;
    }
}
