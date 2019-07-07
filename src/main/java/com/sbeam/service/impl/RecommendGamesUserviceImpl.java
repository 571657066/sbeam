package com.sbeam.service.impl;

import com.sbeam.dao.mappering.RecommendGames;
import com.sbeam.dao.pojo.Games;
import com.sbeam.service.RecommendGamesUservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 随机推荐，销量推荐，底裤折扣推荐
 *
 */
@Service
public class RecommendGamesUserviceImpl implements RecommendGamesUservice {

    @Autowired(required = false)
    RecommendGames recommendGames;

    /**
     * 随机推荐
     * @return
     */
    @Override
    public List<Games> getRecommend() {
        List<Games> rSet = recommendGames.getRecommendGames();

        return rSet;
    }

    /**
     * 销量推荐
     * @return
     */
    @Override
    public List<Games> sealPopular() {
        List<Games> games = recommendGames.sealPopular();
        return games;
    }

    /**
     * 底裤折扣推荐
     * @return
     */
    @Override
    public List<Games> lowDiscount() {
        List<Games> games = recommendGames.lowDiscount();
        return games;
    }
}
