package com.Judas.Dao.Pojo;

import javax.persistence.*;

@Table(name = "gamer_info")
public class Gamer {
    @Id
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String qq;

    /**
     * 已拥有的游戏
     */
    @Column(name = "have_games")
    private String haveGames;

    /**
     * 愿望单里的游戏
     */
    @Column(name = "wish_list")
    private String wishList;

    /**
     * 喜欢的类型
     */
    @Column(name = "like_class")
    private String likeClass;

    /**
     * 年龄 根据用户年龄推荐R18游戏
     */
    private Integer age;

    /**
     * 代表这个玩家有没有被删除
     */
    private Integer flag;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * 获取已拥有的游戏
     *
     * @return have_games - 已拥有的游戏
     */
    public String getHaveGames() {
        return haveGames;
    }

    /**
     * 设置已拥有的游戏
     *
     * @param haveGames 已拥有的游戏
     */
    public void setHaveGames(String haveGames) {
        this.haveGames = haveGames == null ? null : haveGames.trim();
    }

    /**
     * 获取愿望单里的游戏
     *
     * @return wish_list - 愿望单里的游戏
     */
    public String getWishList() {
        return wishList;
    }

    /**
     * 设置愿望单里的游戏
     *
     * @param wishList 愿望单里的游戏
     */
    public void setWishList(String wishList) {
        this.wishList = wishList == null ? null : wishList.trim();
    }

    /**
     * 获取喜欢的类型
     *
     * @return like_class - 喜欢的类型
     */
    public String getLikeClass() {
        return likeClass;
    }

    /**
     * 设置喜欢的类型
     *
     * @param likeClass 喜欢的类型
     */
    public void setLikeClass(String likeClass) {
        this.likeClass = likeClass == null ? null : likeClass.trim();
    }

    /**
     * 获取年龄 根据用户年龄推荐R18游戏
     *
     * @return age - 年龄 根据用户年龄推荐R18游戏
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄 根据用户年龄推荐R18游戏
     *
     * @param age 年龄 根据用户年龄推荐R18游戏
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取代表这个玩家有没有被删除
     *
     * @return flag - 代表这个玩家有没有被删除
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置代表这个玩家有没有被删除
     *
     * @param flag 代表这个玩家有没有被删除
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}