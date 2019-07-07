package com.sbeam.dao.pojo;


/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/2 17:30
 * Description: ∂‘”¶orderinfo±Ì
 */

public class OrderInfo {
    private Integer orderId;
    private Integer userId;
    private String orderNumber;
    private Integer orderStatus;
    private Integer price;
    private Integer pricePaid;
    private String payMode;
    private String title;
    private String createTime;

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderStatus=" + orderStatus +
                ", price=" + price +
                ", pricePaid=" + pricePaid +
                ", payMode='" + payMode + '\'' +
                ", title='" + title + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(Integer pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String creatTime) {
        this.createTime = creatTime;
    }
}
