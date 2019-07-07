package com.sbeam.vo;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/4 16:23
 * Description: No Description
 */
public class AddDetailsVo {
    private Integer gameId;
    private String gameName;
    private String gamePic;
    private Integer price;
    private Integer payPrice;

    @Override
    public String toString() {
        return "AddDetailsVo{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", gamePic='" + gamePic + '\'' +
                ", price=" + price +
                ", payPrice=" + payPrice +
                '}';
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGamePic() {
        return gamePic;
    }

    public void setGamePic(String gamePic) {
        this.gamePic = gamePic;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Integer payPrice) {
        this.payPrice = payPrice;
    }
}
