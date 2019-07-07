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
 * Description: ����һ�����������ɹ�����
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
        // ȥ��long��ʱ�������λ
        long time = parse.getTime() / 1000;
        // �Զ�����ȡģ+1
        int number = orderCount % 9999 + 1;
        // �õ�һ��NumberFormat��ʵ��
        NumberFormat nf = NumberFormat.getInstance();
        // �����Ƿ�ʹ�÷���
        nf.setGroupingUsed(false);
        // �����������λ��
        nf.setMaximumIntegerDigits(4);
        // ������С����λ��
        nf.setMinimumIntegerDigits(4);
        // ������λ�������������λ��ǰ�油0
        Random random = new Random();
        int ends = random.nextInt(99);
        String rand1 = String.format("%02d", ends);
        String rand2 = String.format("%02d", ends);
        // �������ն����Ų�����
        String orderNumber = "O" + time + rand1 + nf.format(number) + rand2;
        return orderNumber;
    }
}
