package com.ripper.budding.learning.basic.exception;

/**
 * @Auther: Yingd [RipperF@hotmail.com]
 * @Date:2021-11-29
 * @Description:com.ripper.budding.learning.basic
 * @Version:1.0
 **/

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *   ┌───────────┐
 *                      │  Object   │
 *                      └───────────┘
 *                            ▲
 *                            │
 *                      ┌───────────┐
 *                      │ Throwable │
 *                      └───────────┘
 *                            ▲
 *                  ┌─────────┴─────────┐
 *                  │                   │
 *            ┌───────────┐       ┌───────────┐
 *            │   Error   │       │ Exception │
 *            └───────────┘       └───────────┘
 *                  ▲                   ▲
 *          ┌───────┘              ┌────┴──────────┐
 *          │                      │               │
 * ┌─────────────────┐    ┌─────────────────┐┌───────────┐
 * │OutOfMemoryError │... │RuntimeException ││IOException│...
 * └─────────────────┘    └─────────────────┘└───────────┘
 *                                 ▲
 *                     ┌───────────┴─────────────┐
 *                     │                         │
 *          ┌─────────────────────┐ ┌─────────────────────────┐
 *          │NullPointerException │ │IllegalArgumentException │...
 *
 * Java使用异常来表示错误，并通过try ... catch捕获异常；
 *
 * Java的异常是class，并且从Throwable继承；
 *
 * Error是无需捕获的严重错误，Exception是应该捕获的可处理的错误；
 *
 * RuntimeException无需强制捕获，非RuntimeException（Checked Exception）需强制捕获，或者用throws声明；
 *
 * 不推荐捕获了异常但不进行任何处理。
 */
public class RipperException {

    public static void main(String[] args) {
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));
    }

    static byte[] toGBK(String s) {
        try {
            // 用指定编码转换String为byte[]:
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
            System.out.println(e); // 打印异常信息
            return s.getBytes(); // 尝试使用用默认编码
        }
    }

    
}
