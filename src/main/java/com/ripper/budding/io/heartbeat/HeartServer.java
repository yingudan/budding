package com.ripper.budding.io.heartbeat;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 心跳客户端线程
 * 
 * @author shadow
 */
public class HeartServer extends Thread {

	private ServerSocket server = null;
	Object obj = new Object();

	@Override
	public void run() {
		try {
			server = new ServerSocket(9090);
			while (true) {
				Socket client = server.accept();
				synchronized (obj) {
					 new Thread(new Client(client)).start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 客户端线程
	 */
	class Client implements Runnable {
		Socket client;

		public Client(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			try {
				while (true) {
					ObjectInput in = new ObjectInputStream(client.getInputStream());
					Heart heart = (Heart) in.readObject();
					System.out.println(heart);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	/**
	 * 客户端出程序的主方法
	 */
	public static void main(String[] args) {
		System.out.println("开始检测客户端是否在线...");
		new HeartServer().start();
	}
}
