package com.sbeam.controller;

import com.sbeam.dao.pojo.AliReturnPay;
import com.sbeam.service.AlipayService;
import com.sbeam.utils.PayUtil;
import com.sbeam.vo.OrderInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/6 11:00
 * Description: No Description
 */
@Controller
@RequestMapping(value = "/alipay")
public class AliPayController {

    private static Logger logger = LoggerFactory.getLogger(AliPayController.class);

    @Autowired
    AlipayService alipayService;


    /**
     * 这是一个实际支付业务的接口
     * @param orderInfoVo 前端需要传递的支付参数
     * @return 返回调用支付宝接口返回的String（一个表单）
     */
    @ResponseBody
    @RequestMapping(value = "toalipay", method = RequestMethod.POST)
    public String aliPay(@RequestBody OrderInfoVo orderInfoVo) {
        System.out.println(orderInfoVo);
        String alipay = PayUtil.alipay(orderInfoVo.getOrderNumber(), orderInfoVo.getPricePaid(), orderInfoVo.getSubject(), orderInfoVo.getBody());
        System.out.println("alipay :\n" + alipay);
        return alipay;
    }

    /**
     * 这是一个测试支付的接口
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "totest", method = RequestMethod.GET)
//    public String aliPay() {
//        String alipay = PayUtil.alipay("O156219895960000160", "9999", "QAQ1", "QAQ1");
//        System.out.println("alipay :\n" + alipay);
//        return alipay;
//    }

    /**
     * 这是支付宝的异步回调接口，支付结果通过这个接口完成校验
     * 执行相关的业务操作
     * @param aliReturnPay 支付宝返回的结果
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping(value = "notify")
    public void aliPayNotify(AliReturnPay aliReturnPay, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("type=text/html;charset=UTF-8");
        logger.info("****************************************支付宝的的回调函数被调用******************************");
        if (!PayUtil.checkSign(request)) {
            logger.info("****************************************验签失败*******************************************");
            response.getWriter().write("failure");
            return;
        }
        if (aliReturnPay == null) {
            logger.info("支付宝的returnPay返回为空！");
            response.getWriter().write("success");
            return;
        }
        logger.info("支付宝的returnPay：\n" + aliReturnPay.toString());
        if (aliReturnPay.getTrade_status().equals("TRADE_SUCCESS")) {
            logger.info("支付宝的支付状态为：TRADE_SUCCESS");
            boolean b = alipayService.aliPaySuccess(aliReturnPay);
            if (b) {
                logger.info("订单数据入库成功！");
            } else {
                logger.info("订单数据入库失败！");
            }
        }
        response.getWriter().write("success");
    }


    /**
     * 这是支付宝返回的同步回调接口
     * 用来做前端页面的跳转，但是支付数据的校验需要在上面的异步回调接口实现
     * @return
     */
    @RequestMapping(value = "return")
    public String aliPayReturn() {
        return "returnpage.html";
    }
}