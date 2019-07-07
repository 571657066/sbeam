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
 * Description: service�ӿ�
 */
@Service
public interface OrderService {
    // �����û�ID��ѯ����
    List<OrderInfo> getOrderInfos(int userId);

    // ���ݶ���ID��ѯ������Ϣ
    List<OrderDetails> getOrderDetails(String orderNumber);

    // ��������
    boolean addOrderInfo(AddOrderInfoVo addOrderInfoVo, HttpSession httpSession);

}
