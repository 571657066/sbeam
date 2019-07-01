package com.sbeam.pojo;

import javax.persistence.*;

@Table(name = "message")
public class TbMessage {
    @Id
    private Integer id;

    /**
     * 主题id
     */
    @Column(name = "topic_id")
    private Integer topicId;

    /**
     * 主题类型
     */
    @Column(name = "topic_type")
    private String topicType;

    /**
     * 相关图片的路径
     */
    @Column(name = "related_img")
    private String relatedImg;

    /**
     * 发布的消息
     */
    private String message;

    /**
     * 评论的用户id
     */
    @Column(name = "form_uid")
    private String formUid;

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
     * 获取主题id
     *
     * @return topic_id - 主题id
     */
    public Integer getTopicId() {
        return topicId;
    }

    /**
     * 设置主题id
     *
     * @param topicId 主题id
     */
    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    /**
     * 获取主题类型
     *
     * @return topic_type - 主题类型
     */
    public String getTopicType() {
        return topicType;
    }

    /**
     * 设置主题类型
     *
     * @param topicType 主题类型
     */
    public void setTopicType(String topicType) {
        this.topicType = topicType == null ? null : topicType.trim();
    }

    /**
     * 获取相关图片的路径
     *
     * @return related_img - 相关图片的路径
     */
    public String getRelatedImg() {
        return relatedImg;
    }

    /**
     * 设置相关图片的路径
     *
     * @param relatedImg 相关图片的路径
     */
    public void setRelatedImg(String relatedImg) {
        this.relatedImg = relatedImg == null ? null : relatedImg.trim();
    }

    /**
     * 获取发布的消息
     *
     * @return message - 发布的消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置发布的消息
     *
     * @param message 发布的消息
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * 获取评论的用户id
     *
     * @return form_uid - 评论的用户id
     */
    public String getFormUid() {
        return formUid;
    }

    /**
     * 设置评论的用户id
     *
     * @param formUid 评论的用户id
     */
    public void setFormUid(String formUid) {
        this.formUid = formUid == null ? null : formUid.trim();
    }
}