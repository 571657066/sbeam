package com.sbeam.pojo;

import javax.persistence.*;

@Table(name = "gamer_speak")
public class TbGamerSpeak {
    @Id
    @Column(name = "gamer_id")
    private Integer gamerId;

    /**
     * 该用户评论过的消息
     */
    @Column(name = "message_id")
    private String messageId;

    /**
     * 该用户评论过的评论
     */
    @Column(name = "comment_id")
    private String commentId;

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
     * 获取该用户评论过的消息
     *
     * @return message_id - 该用户评论过的消息
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 设置该用户评论过的消息
     *
     * @param messageId 该用户评论过的消息
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    /**
     * 获取该用户评论过的评论
     *
     * @return comment_id - 该用户评论过的评论
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * 设置该用户评论过的评论
     *
     * @param commentId 该用户评论过的评论
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }
}