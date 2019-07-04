package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbFriends;
import tk.mybatis.mapper.common.Mapper;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface TbFriendsMapper extends Mapper<TbFriends> {
    /**
     * 查找当前用户的好友
     * @param gamer
     * @return
     */
    public String selectFriend(Gamer gamer);

    /**
     * 根据好友用户名查找他的id
     * @param friendname
     * @return
     */
    public Integer selectFriendId(String friendname);

    /**
     * 将新的好友列表更新到数据库 Integer为用户id String为新的好友列表
     * @param map
     * @return
     */
    public int updateFriends(Map<Integer,String> map);
}