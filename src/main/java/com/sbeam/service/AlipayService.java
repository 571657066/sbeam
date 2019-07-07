package com.sbeam.service;

import com.sbeam.dao.pojo.AliReturnPay;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/6 10:12
 * Description: No Description
 */
@Service
public interface AlipayService {
    boolean aliPaySuccess(AliReturnPay aliReturnPay);
}
