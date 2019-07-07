package com.sbeam.service;

import com.sbeam.dao.pojo.*;
import com.sbeam.dto.ArrayListVo;

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

    /**
     * 根据用户查找他的已有游戏
     * @param gamer
     * @return
     */
    String selectHadGame(Gamer gamer);

    /**
     * 根据gamer查询他的好友的id
     * @param gamer
     * @return
     */

    List<String> selectFriend(Gamer gamer);

    /**
     * 根据好友用户名添加好友(这里的gamer一定要有id，即id不为空，否则无法生效)
     * @param friendname
     * @return
     */
    boolean addFriend(Gamer gamer,String friendname);

    /**
     * 根据好友名删除好友(这里的gamer一定要有id，即id不为空，否则无法生效)
     * @param gamer
     * @param friendname
     * @return
     */
    boolean deletFriend(Gamer gamer,String friendname);

    /**
     * 用户查询某个用户(此处返回的gamer密码为空)
     * @param gamername
     * @return
     */
    Gamer selectOne(String gamername);

    /**
     * 用户购买游戏后 在已有游戏里添加
     * @param gamer
     * @return
     */
    boolean addHadGame(Gamer gamer,String games);

    /**
     * 消息发送给某个人,socket发送和数据库写入
     * @param tbComment
     * @param gamer
     * @return
     */
    boolean speakTo(TbComment tbComment,String gamername,String othername);

    /**
     * 通过socket接收别人发的消息，这里不需要进行数据库写入
     * @return
     */
    boolean receiveFrom();

    /**
     * 将game加入到gamer的购物车
     * @param gamer
     * @param game
     * @return
     */
    boolean changeshopcar(Gamer gamer,TbGame game);


    //分页1
    List<Gamer> getNewsInfoBy();
    //单删
    Integer deleArticeById(Gamer article);
    //模糊查询
    List<Gamer> seletcAtricleId(String getaTitle);
    //多选删除
    Integer allDeleAtricleByIds(ArrayListVo arrayListVo);

}
