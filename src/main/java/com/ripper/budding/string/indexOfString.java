package com.ripper.budding.string;

/**
 * @author shadow
 * @date 2016年10月19日
 */
public class indexOfString {

    public static void main(String[] args) {

        String a = "(是asdas)";
        // System.out.println("int".indexOf(a) == -1);
        if (a.indexOf("是") != -1) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }
    }

}
