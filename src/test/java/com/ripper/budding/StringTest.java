package com.ripper.budding;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 做简单的性能测试比较
 */
public class StringTest {

    public static void main(String[] args) {

        String TestStr = null;
        StringBuffer sb = new StringBuffer();
        StringBuilder sbd = new StringBuilder();

        ArrayList<String> array = new ArrayList<String>();
        array.add("1");


        for (int i = 0; i < 1000; i++) {
            sb.append(i);
            sb.append(";");
        }
//		TestStr = sb.toString().startsWith(prefix);

        Long stTiem = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            TestStr.split(";");
        }
        System.out.println("spendTime:" + (System.currentTimeMillis() - stTiem));

        stTiem = System.currentTimeMillis();

        StringTokenizer st = new StringTokenizer(TestStr, ";");
        for (int i = 0; i < 10000; i++) {
            while (st.hasMoreTokens()) {
                st.nextToken();
            }
            st = new StringTokenizer(TestStr, ";");
        }
        System.out.println("spendTime:" + (System.currentTimeMillis() - stTiem));


    }

}
