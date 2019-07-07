package com.sbeam.service.impl;

import com.sbeam.dao.mapper.OrderMapper;
import com.sbeam.dao.pojo.AliReturnPay;
import com.sbeam.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/6 10:12
 * Description: No Description
 */

@Service
public class AlipayServiceImpl implements AlipayService {
    @Autowired
    OrderMapper orderMapper;

    /**
     * 更新订单状态（订单支付功能）
     *
     * @param aliReturnPay 需要更新的订单
     * @return
     */
    @Override
    @Transactional
    public boolean aliPaySuccess(AliReturnPay aliReturnPay) {
        int i = orderMapper.updateOrderInfo(aliReturnPay.getOut_trade_no());
        int i1 = orderMapper.updateOrderDetails(aliReturnPay.getOut_trade_no());
        System.out.println("i in AlipayServiceImpl aliPaySuccess:" + i);
        System.out.println("i1 in AlipayServiceImpl aliPaySuccess:" + i1);
        return i == 1 && i1 > 1 ? true : false;
    }
}
