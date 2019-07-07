package com.sbeam.dao.mapper;

import com.sbeam.dao.pojo.OrderDetails;
import com.sbeam.dao.pojo.OrderInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/2 17:30
 * Description: No Description
 */
public interface OrderMapper {
    // 根据用户ID查询订单
    List<OrderInfo> getOrderInfos(int userId);

    // 根据订单ID查询订单信息
    List<OrderDetails> getOrderDetails(String orderNumber);

    // 查询当前时间订单数
    int getOrderCounts(String createTime);

    // 新增订单
    int addOrderInfo(OrderInfo orderInfo);

    // 新增订单详情
    int addOrderDetails(List<OrderDetails> orderDetails);

    // 更新订单状态
    int updateOrderInfo(String orderNumber);

    // 更新订单详情
    int updateOrderDetails(String orderNumber);
}
