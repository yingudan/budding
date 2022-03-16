package com.ripper.budding.learning.basic.veight;

/**
 * @author yingd@jccfc.com
 * @since 2022/3/8 15:19
 **/
public class LambdaTest {

    public static void main(String[] args) {
        System.out.println("\"张三\"");
    }

    /**
     * 测试基本
     */
    public void testBase() {

        MathOperation addition = (int a, int b) -> a + b;

        MathOperation subtraction = (a, b) -> a - b;

        MathOperation multiplication = (int a, int b) -> {return a * b;};


    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
