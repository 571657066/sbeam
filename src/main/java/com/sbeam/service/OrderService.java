package com.sbeam.service;

import com.sbeam.dao.pojo.OrderDetails;
import com.sbeam.dao.pojo.OrderInfo;
import com.sbeam.vo.AddOrderInfoVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/2 17:30
 * Description: service接口
 */
@Service
public interface OrderService {
    // 根据用户ID查询订单
    List<OrderInfo> getOrderInfos(int userId);

    // 根据订单ID查询订单信息
    List<OrderDetails> getOrderDetails(String orderNumber);

    // 新增订单
    boolean addOrderInfo(AddOrderInfoVo addOrderInfoVo, HttpSession httpSession);

}
