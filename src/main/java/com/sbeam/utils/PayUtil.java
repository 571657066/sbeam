package com.sbeam.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.sbeam.config.AlipayConfig;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/5 17:48
 * Description: No Description
 */
public class PayUtil {


    /**
     *
     * @param outTradeNo  �̻������ţ��̻���վ����ϵͳ��Ψһ�����ţ�����   ��Ӧ�ɷѼ�¼��orderNo
     * @param totalAmount  ���������
     * @param subject ����
     * @param body ��Ʒ�������ɿ�
     * @return
     */
    public static String alipay(String outTradeNo,String totalAmount,String subject,String body) {
        //��ó�ʼ����AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //�����������
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ outTradeNo +"\","
                    + "\"total_amount\":\""+ totalAmount +"\","
                    + "\"subject\":\""+ subject +"\","
                    + "\"timeout_express\":\"90m\","
                    + "\"body\":\""+ body +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            //����
            String result;

            result = alipayClient.pageExecute(alipayRequest).getBody();
            System.out.println("*********************\n���ؽ��Ϊ��"+result);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * ֧�����˿�ӿ�
     * @param outTradeNo
     * @param tradeNo
     * @param refundAmount
     * @param refundReason
     * @param out_request_no  ��ʶһ���˿�����ͬһ�ʽ��׶���˿���Ҫ��֤Ψһ�����貿���˿��˲����ش�
     * @return
     */
    public static String aliRefund(String outTradeNo,String tradeNo,String refundAmount,String refundReason,String out_request_no) {
        //��ó�ʼ����AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //�����������
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ outTradeNo +"\","
                    + "\"trade_no\":\""+ tradeNo +"\","
                    + "\"refund_amount\":\""+ refundAmount +"\","
                    + "\"refund_reason\":\""+ refundReason +"\","
                    + "\"out_request_no\":\""+ out_request_no +"\"}");

            //����
            String result;

            //����
            result = alipayClient.execute(alipayRequest).getBody();
            System.out.println("*********************\n���ؽ��Ϊ��"+result);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * ֧��������ǩ����
     * @param req
     * @return
     */
    public static boolean checkSign(HttpServletRequest req) {
        Map<String, String[]> requestMap = req.getParameterMap();
        Map<String, String> paramsMap = new HashMap<>();
        requestMap.forEach((key, values) -> {
            String strs = "";
            for(String value : values) {
                strs = strs + value;
            }
            System.out.println(("keyֵΪ"+key+"valueΪ��"+strs));
            paramsMap.put(key, strs);
        });

        //����SDK��֤ǩ��
        try {
            return  AlipaySignature.rsaCheckV1(paramsMap, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("*********************��ǩʧ��********************");
            return false;
        }
    }
}
