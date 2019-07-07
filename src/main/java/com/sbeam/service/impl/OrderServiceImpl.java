package com.sbeam.service.impl;

import com.sbeam.dao.mapper.OrderMapper;
import com.sbeam.dao.pojo.OrderDetails;
import com.sbeam.dao.pojo.OrderInfo;
import com.sbeam.service.OrderService;
import com.sbeam.utils.OrderNumberGenerator;
import com.sbeam.vo.AddDetailsVo;
import com.sbeam.vo.AddOrderInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/2 17:31
 * Description: serviceʵ����
 */
@Service
public class OrderServiceImpl implements OrderService {
    // ʵ����һ�����������ɹ��߶���
    private OrderNumberGenerator orderNumberGenerator = new OrderNumberGenerator();
    @Autowired
    OrderMapper orderMapper;

    /**
     * �����û�ID��ѯ����
     *
     * @param userId �û�ID
     * @return ��������
     */
    @Override
    public List<OrderInfo> getOrderInfos(int userId) {
        return orderMapper.getOrderInfos(userId);
    }

    /**
     * ���ݶ����Ų�ѯ��������
     *
     * @param orderNumber ������
     * @return
     */
    @Override
    public List<OrderDetails> getOrderDetails(String orderNumber) {
        return orderMapper.getOrderDetails(orderNumber);
    }

    /**
     * ��������
     *
     * @param addOrderInfoVo ��Ҫ��ӵĶ�����Ϣ
     * @return ���������Ƿ�ɹ�
     */
    @Override
    @Transactional
    public boolean addOrderInfo(AddOrderInfoVo addOrderInfoVo, HttpSession httpSession) {
        OrderInfo orderInfo = new OrderInfo();
        String createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        orderInfo.setCreateTime(createTime);
        // ���ݶ����������ڲ�ѯ������
        int orderCounts = orderMapper.getOrderCounts(createTime);
        // ���ɶ�����
        String orderNumber = orderNumberGenerator.getOrderNumber(createTime, orderCounts);
        orderInfo.setOrderNumber(orderNumber);
        orderInfo.setPrice(addOrderInfoVo.getPrice());
        orderInfo.setPricePaid(addOrderInfoVo.getPricePaid());
        orderInfo.setTitle(addOrderInfoVo.getTitle());
        orderInfo.setUserId(addOrderInfoVo.getUserId());
        int i = orderMapper.addOrderInfo(orderInfo);
        List<AddDetailsVo> games = addOrderInfoVo.getGames();
        OrderDetails orderDetails = new OrderDetails();
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        for (AddDetailsVo addDetailsVo : games) {
            orderDetails.setGameId(addDetailsVo.getGameId());
            orderDetails.setGameName(addDetailsVo.getGameName());
            orderDetails.setGamePic(addDetailsVo.getGamePic());
            orderDetails.setPayPrice(addDetailsVo.getPayPrice());
            orderDetails.setPrice(addDetailsVo.getPrice());
            orderDetails.setOrderNumber(orderNumber);
            orderDetailsList.add(orderDetails);
        }
        int i1 = orderMapper.addOrderDetails(orderDetailsList);
        boolean b = i == 1 && i1 >= 1 ? true : false;
        if (b) {
            httpSession.setAttribute("orderNumber", orderNumber);
        }
        return b;
    }
}
