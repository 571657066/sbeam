package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.Games;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 * 游客/用户游戏推荐
 */
@Repository
public interface RecommendGames {

    //获取随机推荐游戏
     List<Games> getRecommendGames();


     //销量热门推荐
     List<Games> sealPopular();

     //底裤折扣推荐
    public List<Games> lowDiscount();
}
