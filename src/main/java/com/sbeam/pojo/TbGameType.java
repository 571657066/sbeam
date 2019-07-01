package com.sbeam.pojo;

import javax.persistence.*;

@Table(name = "game_type")
public class TbGameType {
    @Id
    private Integer id;

    @Column(name = "type_name")
    private String typeName;

    /**
     * 这一类型的游戏
     */
    private String games;

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
     * 获取这一类型的游戏
     *
     * @return games - 这一类型的游戏
     */
    public String getGames() {
        return games;
    }

    /**
     * 设置这一类型的游戏
     *
     * @param games 这一类型的游戏
     */
    public void setGames(String games) {
        this.games = games == null ? null : games.trim();
    }
}