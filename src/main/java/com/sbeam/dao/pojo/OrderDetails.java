package com.sbeam.dao.pojo;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/4 16:11
 * Description: ∂‘”¶orderdeails±Ì
 */
public class OrderDetails {
    private Integer orderDetailId;
    private Integer gameId;
    private String gameName;
    private String gamePic;
    private Integer price;
    private Integer payPrice;
    private String orderNumber;
    private Integer detailStatus;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDetailId=" + orderDetailId +
                ", gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", gamePic='" + gamePic + '\'' +
                ", price=" + price +
                ", payPrice=" + payPrice +
                ", orderNumber='" + orderNumber + '\'' +
                ", detailStatus=" + detailStatus +
                '}';
    }

    public Integer getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(Integer detailStatus) {
        this.detailStatus = detailStatus;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
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
