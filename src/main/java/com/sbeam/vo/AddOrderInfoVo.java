package com.sbeam.vo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/4 14:55
 * Description: No Description
 */
public class AddOrderInfoVo {
    private Integer userId;
    private Integer price;
    private Integer pricePaid;
    private String title;
    private List<AddDetailsVo> games;

    @Override
    public String toString() {
        return "AddOrderInfoVo{" +
                "userId=" + userId +
                ", price=" + price +
                ", pricePaid=" + pricePaid +
                ", title='" + title + '\'' +
                ", games=" + games +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(Integer pricePaid) {
        this.pricePaid = pricePaid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AddDetailsVo> getGames() {
        return games;
    }

    public void setGames(List<AddDetailsVo> games) {
        this.games = games;
    }
}
