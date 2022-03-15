package com.ripper.budding.utils;

import com.ripper.budding.exception.MessageException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-01-13
 * @Description:com.ripper.budding.utils
 * @Version:1.0
 **/


public class HttpClient {

    public static final int errNum = 3;

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();

        try {
            Object o = callBackGetData(params, "");
            System.out.println("ceshi>>"+o);
        } catch (MessageException e) {
            e.printStackTrace();
        }
    }


    /**
     * @return
     */
    public static Object callBackGetData(Map<String, String> params, int errorNum, String httpHead) throws MessageException {
        String sendUrl = "demo";
        boolean isGetSuccess = false;// 判断是否请求成功 用于跳转错误
        String resDto = null;// 请求响应返回的数据
        try {
            String httpRes = HttpClient.syncGet(sendUrl, params);// 发送请求
            if (!StringUtils.isEmpty(httpRes)) {
                resDto = httpRes;
                isGetSuccess = true;
                return  resDto;
            }
        } catch (Exception e) {
            e.printStackTrace();
            isGetSuccess = false;
        }
        System.out.println("第" + errorNum + "次，尝试重新请求");
        if (Boolean.FALSE ==isGetSuccess) {
            if (errorNum == 2) {
                return "123456";
            }
            if (errorNum < errNum) {
                try {
                    Thread.sleep(1000);// 休息一秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                errorNum++;
                Object o = callBackGetData(params, errorNum, httpHead);// 再次请求
                if(o!=null){
                    return o;
                }
            }
            throw new MessageException("请求服务器失败");
        }
        return resDto;
    }


    public static Object callBackGetData(Map<String, String> params, String httpHead) throws MessageException {
        return callBackGetData(params, 0, httpHead);
    }

    public static String syncGet(String sendUrl, Map<String, String> params) throws Exception {
        if (sendUrl == null) {
            throw new Exception("请求地址有误");
        }
        return "1";
    }

}
