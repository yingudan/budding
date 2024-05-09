package com.ripper.budding.io.heartbeat;

/**
 * 心跳客户端
 * 
 * @author shadow
 */
public class HeartClient extends Thread {

	@Override
	public void run() {
		try {
			while (true) {
				HeartSender.getInstance().send();
				synchronized (HeartClient.class) {
					Thread.sleep(2000);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 程序的入口main方法
	 */
	public static void main(String[] args) {
		HeartClient client = new HeartClient();
		client.start();
	}
}
