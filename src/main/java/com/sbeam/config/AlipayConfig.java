package com.sbeam.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/7/5 19:33
 * Description: No Description
 */
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100659201";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCWrnq1Vqqln8ftjCCoxcN1DD3gZMrINkGPR8o/mWuayHMGigVphXnSiKjSOMmpmR1iYcGHiGFOauw2kddftpNAfXV7bagt/SaIkGGaqKhKOJ3dKxEhJJW9CYLar9IhL10rfQKNXGCiS1bMbClVyd0Fyy55hVPA6UcdRZvMcoI4zqg7Wo2O6GdfRCmDxuB0MvELIEg0A7LmUEuup03SguE3yJhDTzlEFGFkQktnXWBzNX8m9/EUT6yo+qY2lmUlVrEITN+Z/CXnMcAsMvNoVpezD52/eggVVPfp0OLl6o/NGcxXK1jTptFpl7aE0JK97ujbbPiv3L2C0O0slrZsr2d3AgMBAAECggEAAP0YFQSCjh+kQiy/MhxKEgSIi2Zd5j5k47nG2+/3wsY56vsQ2gZkLDt1UBvLRu+YP8MAcBE3Ajq1Xg5K6XfbM3sfQDYR+mtEy3SXD1q37/S7JG5Z6GvDB8B+OU0aBdm3tMdXMvI+OBJieWjkRInUh2sz3NxBFmzxaIHCae7+Z70AyorqQba3BxLRHvP7K2kWo/V6Nw572DFJ3DHEwiacBxDUc7wNoIv0zS9f5TWr59njPPOIA9S0zOIvnIVuARy8s8MmsprcwwXa1bOyLXTJeljHocfZoIubElL6gyaJe4/OaCkzSSNd6wJdNkJlLVvlgXd4kODwhqB4n++z+mhVkQKBgQDY2KFOqZbWXPJdNFLnbZk++mM2yp4UKybZ2Qr8P8rif3jNknCY1dY4C4fcfmTjl9Tk07VW1BVpAoSeDK2hC/5E3v7EeSjzzhktRyvaxHBs3AAwZRTQRMe4r2W49CuPjmCHVi3Qafc2njS2yBkrBXFmGERQ7ZJ+Lrk4w8A16PpVQwKBgQCx435s9WjwZAyfM2ku+CiMh7z25gEQoqxj2pgt5nGjOscmCd8Bte7F1tZd5Hc6dkqFlXsuRvFBg1f4Q3wZga90MusBE/0/Q5gQLoj0O7vv0iTfU48+uTHKlOG8UsIyMgyjFqghz7KMSD30plO41Z5V5RuJyIm1dzhMk4IDbOXnvQKBgEvweXUZ0PgbLslTNKFVcXBrsWkTxg5cGkv6RW2XTY7Kg1zCpunvIQkZiKfAH8bQej70oTHaLfFLb3QGDpwyngYybdgScjQHfiusHACOAK0u0mYgUAyruaHE0wPVhpfMjaN3m628HlYjS2SjaKT3UAIoB2yr9jx4Umc9rkdy4pAPAoGAWIOcStcqKkN+TFEmi2qLsrFwA2KbMQ3gvabthhlefhwnL/RFdPJ0JxkpfXrLINnvZtzkeDhwn2qdgTkDLSXsieM0MEsj/jDCH3soRm7aqxBjrIRFiK5Z6jV+xVhgrN1ekGAbtQdGDqt7uJpymkwhBxiDRWH1s8foyaG0VcP/+fkCgYEAwExZI6PQAqS6LFsKD9tmrrT7nPenuv0cCeQ8u2gl8GP4PC6V1En3FSN4MLCbY5IZAYpZwAn9GocK27BbjQw9qBJ8DrWL5r5Mx5P4rnO9vE8hPaRZbr1R8tmXhgxmi2sKB8FC90jpQKdWtXRjYo9oqPok4psJwgvxBF72aheNmAQ=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk6SPGK9cDr0jVtdXBOSlTeDARMEh/8Y6EHkBzLQ32r1GFAoHzs07oTS0tcyLMESRs3HRJdy43BSdre97Uh7mzegquPeCMRoZNZVuaDMZeHjaCR2ITf7CLd6eFyUPWnwR9PbpnQ/Ha7CVqjY33WKdbGMsUbw6NOiRaPI0JxViFcdG+9sHOJtQ9DP9mJ11t2NSUW2mQ1nrRjbxKCuEEQ8TSmZYtFy2HMdUzDpwboivS28jfU/K/7oLzjSR5govP0D5LlkMJK2fvOVCiAAR7/qbSCAXDqf5YGTQJHZla4ZV+hi+C2GUkbDFpkRJR74UKr2RiSEBwu1R1r/lkiY5ZFiQEQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://vidjam.natappfree.cc/alipay/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://vidjam.natappfree.cc/alipay/return";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
//	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
    // 沙箱环境网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";


    // 日志地址
    public static String log_path = "C:/Users/Jason/Desktop/1902项目文件/sbeam/logs/";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
