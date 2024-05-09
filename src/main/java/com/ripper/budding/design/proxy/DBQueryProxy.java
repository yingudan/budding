package com.ripper.budding.design.proxy;

/**
 * @author shadow 基于DBQuery的代理
 */
public class DBQueryProxy implements IDBQuery {

    private DBQuery real = null;

    @Override
    public String request() {
        // 在真正需要的时候，才创建真是对象
        if (real == null)
            real = new DBQuery();
        // 在多线程情况下
        return real.request();
    }

    public static void main(String[] args) {// 真正需要调用的时候
        IDBQuery q = new DBQueryProxy();
        q.request();
    }


}
