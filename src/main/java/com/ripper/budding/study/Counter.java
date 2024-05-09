package com.ripper.budding.study;

/**
 * 多线程
 * 
 * @author shadow
 */
public class Counter {

	public volatile static int count = 0;

	public  static void inc() {
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		count++;
	}

	/**
	 * 同时开启1000个线程去做累加操作
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Counter.inc();
				}
			}).start();
		}
		System.out.println(Counter.count);
	}

}
