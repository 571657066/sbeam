package com.sbeam.dao.pojo;

/**
 * @author hong
 */
public class Gamers {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String qq;
    private String have_games;
    private String wish_list;
    private String like_class;
    private String birthday;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getHave_games() {
        return have_games;
    }

    public void setHave_games(String have_games) {
        this.have_games = have_games;
    }

    public String getWish_list() {
        return wish_list;
    }

    public void setWish_list(String wish_list) {
        this.wish_list = wish_list;
    }

    public String getLike_class() {
        return like_class;
    }

    public void setLike_class(String like_class) {
        this.like_class = like_class;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", have_games='" + have_games + '\'' +
                ", wish_list='" + wish_list + '\'' +
                ", like_class='" + like_class + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                '}';
    }
}
