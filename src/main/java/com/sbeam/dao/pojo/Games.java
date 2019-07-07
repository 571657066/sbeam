package com.sbeam.dao.pojo;

/**
 *
 * 游客推荐游戏实体类
 */
public class Games {
    private int id;
    private String gamename;
    private Double original_price;//原价
    private Double discount;
    private Double now_price;//现价
    private String img_path;//游戏图片路径
    private String type;//游戏类型
    private String desc;//游戏简介
    private String developer;//开发商
    private int sales;//销量

    public String getType() {
        return type;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    public Double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Double original_price) {
        this.original_price = original_price;
    }

    public Double getNow_price() {
        return now_price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setNow_price(Double now_price) {
        this.now_price = now_price;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", gamename='" + gamename + '\'' +
                ", original_price=" + original_price +
                ", discount=" + discount +
                ", now_price=" + now_price +
                ", img_path='" + img_path + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", developer='" + developer + '\'' +
                ", sales=" + sales +
                '}';
    }
}
