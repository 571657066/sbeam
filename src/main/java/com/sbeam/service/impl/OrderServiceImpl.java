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
 * Description: service实现类
 */
@Service
public class OrderServiceImpl implements OrderService {
    // 实例化一个订单号生成工具对象
    private OrderNumberGenerator orderNumberGenerator = new OrderNumberGenerator();
    @Autowired
    OrderMapper orderMapper;

    /**
     * 根据用户ID查询订单
     *
     * @param userId 用户ID
     * @return 订单集合
     */
    @Override
    public List<OrderInfo> getOrderInfos(int userId) {
        return orderMapper.getOrderInfos(userId);
    }

    /**
     * 根据订单号查询订单详情
     *
     * @param orderNumber 订单号
     * @return
     */
    @Override
    public List<OrderDetails> getOrderDetails(String orderNumber) {
        return orderMapper.getOrderDetails(orderNumber);
    }

    /**
     * 新增订单
     *
     * @param addOrderInfoVo 需要添加的订单信息
     * @return 新增订单是否成功
     */
    @Override
    @Transactional
    public boolean addOrderInfo(AddOrderInfoVo addOrderInfoVo, HttpSession httpSession) {
        OrderInfo orderInfo = new OrderInfo();
        String createTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        orderInfo.setCreateTime(createTime);
        // 根据订单创建日期查询订单数
        int orderCounts = orderMapper.getOrderCounts(createTime);
        // 生成订单号
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
