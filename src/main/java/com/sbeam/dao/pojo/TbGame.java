package com.sbeam.dao.pojo;

import javax.persistence.*;

@Table(name = "game_info")
public class TbGame {
    @Id
    private Integer id;

    private String gamename;

    /**
     * 原价
     */
    @Column(name = "original_price")
    private Long originalPrice;

    /**
     * 现在价钱
     */
    @Column(name = "now_price")
    private Long nowPrice;

    /**
     * 史低
     */
    @Column(name = "lowest_price")
    private Long lowestPrice;

    /**
     * 当前折扣
     */
    private Double discount;

    /**
     * 游戏类型
     */
    private String type;

    /**
     * 简介
     */
    private String intro;

    /**
     * 游戏文件的路径
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * 游戏图片的路径
     */
    @Column(name = "img_path")
    private String imgPath;

    /**
     * 开发商
     */
    private String developer;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 该游戏的评论
     */
    @Column(name = "about_topicid")
    private String topicId;


    /**
     * 0表示审核中游戏，1表示上架的游戏，2表示下架的游戏
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
     * @return gamename
     */
    public String getGamename() {
        return gamename;
    }

    /**
     * @param gamename
     */
    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    /**
     * 获取原价
     *
     * @return original_price - 原价
     */
    public Long getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置原价
     *
     * @param originalPrice 原价
     */
    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取现在价钱
     *
     * @return now_price - 现在价钱
     */
    public Long getNowPrice() {
        return nowPrice;
    }

    /**
     * 设置现在价钱
     *
     * @param nowPrice 现在价钱
     */
    public void setNowPrice(Long nowPrice) {
        this.nowPrice = nowPrice;
    }

    /**
     * 获取史低
     *
     * @return lowest_price - 史低
     */
    public Long getLowestPrice() {
        return lowestPrice;
    }

    /**
     * 设置史低
     *
     * @param lowestPrice 史低
     */
    public void setLowestPrice(Long lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    /**
     * 获取当前折扣
     *
     * @return discount - 当前折扣
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * 设置当前折扣
     *
     * @param discount 当前折扣
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    /**
     * 获取游戏类型
     *
     * @return type - 游戏类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置游戏类型
     *
     * @param type 游戏类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取简介
     *
     * @return desc - 简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置简介
     *
     * @param intro 简介
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * 获取游戏文件的路径
     *
     * @return file_path - 游戏文件的路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置游戏文件的路径
     *
     * @param filePath 游戏文件的路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * 获取游戏图片的路径
     *
     * @return img_path - 游戏图片的路径
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 设置游戏图片的路径
     *
     * @param imgPath 游戏图片的路径
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    /**
     * 获取开发商
     *
     * @return developer - 开发商
     */
    public String getDeveloper() {
        return developer;
    }

    /**
     * 设置开发商
     *
     * @param developer 开发商
     */
    public void setDeveloper(String developer) {
        this.developer = developer == null ? null : developer.trim();
    }

    /**
     * 获取销量
     *
     * @return sales - 销量
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * 设置销量
     *
     * @param sales 销量
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }


    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }



    /**
     * 获取0表示审核中游戏，1表示上架的游戏，2表示下架的游戏
     *
     * @return flag - 0表示审核中游戏，1表示上架的游戏，2表示下架的游戏
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置0表示审核中游戏，1表示上架的游戏，2表示下架的游戏
     *
     * @param flag 0表示审核中游戏，1表示上架的游戏，2表示下架的游戏
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TbGame{" +
                "id=" + id +
                ", gamename='" + gamename + '\'' +
                ", originalPrice=" + originalPrice +
                ", nowPrice=" + nowPrice +
                ", lowestPrice=" + lowestPrice +
                ", discount=" + discount +
                ", type='" + type + '\'' +
                ", intro='" + intro + '\'' +
                ", filePath='" + filePath + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", developer='" + developer + '\'' +
                ", sales=" + sales +
                ", topicId='" + topicId + '\'' +
                ", flag=" + flag +
                '}';
    }
}