package com.sbeam.dao.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/6 10:08
 * Description: No Description
 */
public class AliReturnPay implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * �����ߵ�app_id
     */
    private String app_id;

    /**
     * �̻�������
     */
    private String out_trade_no;

    /**
     * ǩ��
     */
    private String sign;

    /**
     * ����״̬
     */
    private String trade_status;

    /**
     * ֧�������׺�
     */
    private String trade_no;

    /**
     * ���׵Ľ��
     */
    private String total_amount;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "AliReturnPay{" +
                "app_id='" + app_id + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", sign='" + sign + '\'' +
                ", trade_status='" + trade_status + '\'' +
                ", trade_no='" + trade_no + '\'' +
                ", total_amount='" + total_amount + '\'' +
                '}';
    }
}
