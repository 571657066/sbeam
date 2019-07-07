package com.sbeam.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/4 14:08
 * Description: 这是一个订单号生成工具类
 */
public class OrderNumberGenerator {
    public String getOrderNumber(String currentTime, int orderCount) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = null;
        try {
            parse = dateFormat.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 去除long型时间最后三位
        long time = parse.getTime() / 1000;
        // 对订单数取模+1
        int number = orderCount % 9999 + 1;
        // 得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        // 设置是否使用分组
        nf.setGroupingUsed(false);
        // 设置最大整数位数
        nf.setMaximumIntegerDigits(4);
        // 设置最小整数位数
        nf.setMinimumIntegerDigits(4);
        // 生成两位随机数，不足两位的前面补0
        Random random = new Random();
        int ends = random.nextInt(99);
        String rand1 = String.format("%02d", ends);
        String rand2 = String.format("%02d", ends);
        // 生成最终订单号并返回
        String orderNumber = "O" + time + rand1 + nf.format(number) + rand2;
        return orderNumber;
    }
}
