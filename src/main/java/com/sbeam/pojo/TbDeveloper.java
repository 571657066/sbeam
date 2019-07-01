package com.sbeam.pojo;

import javax.persistence.*;

@Table(name = "gamedeveloper_info")
public class TbDeveloper {
    @Id
    private Integer id;

    private String developername;

    private String password;

    /**
     * 已发布游戏
     */
    @Column(name = "released_game")
    private String releasedGame;

    /**
     * 审核中的游戏
     */
    @Column(name = "debug_game")
    private String debugGame;

    @Column(name = "message_ids")
    private String messageIds;

    @Column(name = "alipay_id")
    private String alipayId;

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
     * @return developername
     */
    public String getDevelopername() {
        return developername;
    }

    /**
     * @param developername
     */
    public void setDevelopername(String developername) {
        this.developername = developername == null ? null : developername.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取已发布游戏
     *
     * @return released_game - 已发布游戏
     */
    public String getReleasedGame() {
        return releasedGame;
    }

    /**
     * 设置已发布游戏
     *
     * @param releasedGame 已发布游戏
     */
    public void setReleasedGame(String releasedGame) {
        this.releasedGame = releasedGame == null ? null : releasedGame.trim();
    }

    /**
     * 获取审核中的游戏
     *
     * @return debug_game - 审核中的游戏
     */
    public String getDebugGame() {
        return debugGame;
    }

    /**
     * 设置审核中的游戏
     *
     * @param debugGame 审核中的游戏
     */
    public void setDebugGame(String debugGame) {
        this.debugGame = debugGame == null ? null : debugGame.trim();
    }

    /**
     * @return message_ids
     */
    public String getMessageIds() {
        return messageIds;
    }

    /**
     * @param messageIds
     */
    public void setMessageIds(String messageIds) {
        this.messageIds = messageIds == null ? null : messageIds.trim();
    }

    /**
     * @return alipay_id
     */
    public String getAlipayId() {
        return alipayId;
    }

    /**
     * @param alipayId
     */
    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId == null ? null : alipayId.trim();
    }
}