package com.sbeam.dao.mappering;


import com.sbeam.dao.pojo.Games;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 *
 * 用户游戏推荐
 */
@Repository
public interface LikeGamesDao {
    //用户点击类型推荐
    public List<Games> getGamesByType(String type);

    //用户喜欢类型推荐
    public String likeTypes(int id);

    public List<Games> likeTypesGet(String[] s);
}
