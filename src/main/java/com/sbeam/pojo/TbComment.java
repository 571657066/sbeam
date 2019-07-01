package com.sbeam.pojo;

import javax.persistence.*;

@Table(name = "comment")
public class TbComment {
    @Id
    private Integer id;

    /**
     * 评论消息或评论的id
     */
    @Column(name = "speak_id")
    private Integer speakId;

    /**
     * 评论的用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 评论的内容
     */
    private String content;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取评论消息或评论的id
     *
     * @return speak_id - 评论消息或评论的id
     */
    public Integer getSpeakId() {
        return speakId;
    }

    /**
     * 设置评论消息或评论的id
     *
     * @param speakId 评论消息或评论的id
     */
    public void setSpeakId(Integer speakId) {
        this.speakId = speakId;
    }

    /**
     * 获取评论的用户id
     *
     * @return user_id - 评论的用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置评论的用户id
     *
     * @param userId 评论的用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取评论的内容
     *
     * @return content - 评论的内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论的内容
     *
     * @param content 评论的内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}