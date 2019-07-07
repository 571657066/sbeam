package com.sbeam.vo;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/5 19:26
 * Description: No Description
 */
public class OrderInfoVo {
    private String orderNumber;
    private String pricePaid;
    private String subject;
    private String body;

    @Override
    public String toString() {
        return "OrderInfoVo{" +
                "orderNumber='" + orderNumber + '\'' +
                ", pricePaid=" + pricePaid +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public String getPricePaid() {

        return pricePaid;
    }

    public void setPricePaid(String pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
