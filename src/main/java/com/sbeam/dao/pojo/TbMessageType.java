package com.sbeam.dao.pojo;

import javax.persistence.*;

@Table(name = "message_type")
public class TbMessageType {
    @Id
    private Integer id;


    @Column(name = "type_name")
    private String typeName;
    /**
     * 这一类型的消息id
     */
    @Column(name = "message_id")
    private String messageId;

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
     * @return type_name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 获取这一类型的消息id
     *
     * @return message_id - 这一类型的消息id
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 设置这一类型的消息id
     *
     * @param messageId 这一类型的消息id
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }
}