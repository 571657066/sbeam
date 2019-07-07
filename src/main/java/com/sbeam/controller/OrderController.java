package com.sbeam.controller;

import com.sbeam.dao.pojo.OrderDetails;
import com.sbeam.dao.pojo.OrderInfo;
import com.sbeam.service.OrderService;
import com.sbeam.vo.AddOrderInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/2 17:28
 * Description: No Description
 */

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * �����û�ID��ѯ����
     * localhost:8080/getOrderInfos?userId=1
     *
     * @param userId �û�ID
     * @return ��������
     */
    @RequestMapping(value = "getOrderInfos", method = RequestMethod.GET)
    public List<OrderInfo> getOrderInfos(@RequestParam int userId) {
        return orderService.getOrderInfos(userId);
    }

    /**
     * ���ݶ����Ų�ѯ������ϸ��Ϣ
     * localhost:8080/getOrderDetails?orderNumber=O156219895960000160
     *
     * @param orderNumber ������
     * @return ��������
     */
    @RequestMapping(value = "getOrderDetails", method = RequestMethod.GET)
    public List<OrderDetails> getOrderDetails(@RequestParam String orderNumber) {
        return orderService.getOrderDetails(orderNumber);
    }

    /**
     * ���ɶ���
     * {
     * "userId":1,
     * "price":12,
     * "pricePaid":12,
     * "title":"QAQ",
     * "games":
     * [{
     * "gameId": 1,
     * "gameName": "QAQ",
     * "gamePic": "1.jpg",
     * "price": 12,
     * "payPrice": 12
     * }, {
     * "gameId": 1,
     * "gameName": "QAQ",
     * "gamePic": "1.jpg",
     * "price": 12,
     * "payPrice": 12
     * }, {
     * "gameId": 1,
     * "gameName": "QAQ",
     * "gamePic": "1.jpg",
     * "price": 12,
     * "payPrice": 12
     * }]
     * }
     *
     * @param addOrderInfoVo ���ɶ���������Ϣ
     * @return ���ɵĶ�����orderNumber
     */
    @RequestMapping(value = "addOrderInfo", method = RequestMethod.POST)
    public String addOrderInfo(@RequestBody AddOrderInfoVo addOrderInfoVo, HttpSession httpSession) {
        boolean b = orderService.addOrderInfo(addOrderInfoVo,httpSession);
        if (b) {
            String orderNumber = (String) httpSession.getAttribute("orderNumber");
            return orderNumber;
        }
        return "null";
    }
}
