package com.ripper.budding.design.proxy;

/**
 * @author shadow
 * DBQ对象
 */
public class DBQuery implements IDBQuery {

	public DBQuery() {
		try {
			Thread.sleep(1000); // 模拟一些初始化操作
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String request() {
		return "request String";
	}
}
