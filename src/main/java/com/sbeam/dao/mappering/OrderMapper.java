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
    // �����û�ID��ѯ����
    List<OrderInfo> getOrderInfos(int userId);

    // ���ݶ���ID��ѯ������Ϣ
    List<OrderDetails> getOrderDetails(String orderNumber);

    // ��ѯ��ǰʱ�䶩����
    int getOrderCounts(String createTime);

    // ��������
    int addOrderInfo(OrderInfo orderInfo);

    // ������������
    int addOrderDetails(List<OrderDetails> orderDetails);

    // ���¶���״̬
    int updateOrderInfo(String orderNumber);

    // ���¶�������
    int updateOrderDetails(String orderNumber);
}
