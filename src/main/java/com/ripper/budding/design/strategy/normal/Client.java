package com.ripper.budding.design.strategy.normal;

public class Client {

    public static void main(String[] args) {
        // 创建Manager, 管理策略类(需要传入)
        Context ctx = new Context(new OldCustomerManyStrategy());

        // 调用Manager的具体方法, 负责根据当前的策略类, 计算出对应策略的报价
        ctx.printPrice(1000);
    }
}
