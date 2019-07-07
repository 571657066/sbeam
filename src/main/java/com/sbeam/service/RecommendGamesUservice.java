package com.sbeam.service;

import com.sbeam.dao.pojo.Games;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendGamesUservice {

    //获取随机推荐游戏
    List<Games> getRecommend();

    //销量热门推荐
    List<Games> sealPopular();

    //底裤折扣推荐
    public List<Games> lowDiscount();
}
