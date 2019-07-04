package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.Gamer;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface GamerMapper extends Mapper<Gamer> {
    /**
     * 根据gamer查询gamer是否存在
     * @param gamer
     * @return
     */
    Gamer selectOneUser(Gamer gamer);

    /**
     * 根据gamer添加用户
     * @param gamer
     * @return
     */
    int insertOneUser(Gamer gamer);

    /**
     * 根据gamer更新gamer
     * @param gamer
     * @return
     */
    int updateOneUser(Gamer gamer);

    /**
     * 根据用户查找他的愿望单
     * @param gamer
     * @return
     */
    String  selectWishGame(Gamer gamer);

    /**
     * 将map里的游戏id添加到用户里
     * @param
     * @return
     */
    int addWishGame(Map<String ,String> map);

    /**
     * 查询用户已有的游戏
     * @param gamer
     * @return
     */
    String selectHadGame(Gamer gamer);
    /**
     * 用户购买游戏后添加进数据库
     * @param map
     * @return
     */
    int addHadGame(Map<String ,String> map);

    /**
     * 根据用户名查询某个用户
     * @param gamername
     * @return
     */
    Gamer selectGamer(String gamername);
}