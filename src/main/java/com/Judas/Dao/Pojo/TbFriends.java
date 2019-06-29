package com.Judas.Dao.Pojo;

import javax.persistence.*;

@Table(name = "gamer_friends")
public class TbFriends {
    @Id
    @Column(name = "gamer_id")
    private Integer gamerId;

    /**
     * 好友的id
     */
    @Column(name = "friend_id")
    private String friendId;

    /**
     * @return gamer_id
     */
    public Integer getGamerId() {
        return gamerId;
    }

    /**
     * @param gamerId
     */
    public void setGamerId(Integer gamerId) {
        this.gamerId = gamerId;
    }

    /**
     * 获取好友的id
     *
     * @return friend_id - 好友的id
     */
    public String getFriendId() {
        return friendId;
    }

    /**
     * 设置好友的id
     *
     * @param friendId 好友的id
     */
    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }
}