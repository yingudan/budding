package com.ripper.budding.io.heartbeat;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 心跳消息发送者
 * 
 * @author shadow
 */
public class HeartSender {

	private HeartSender() {
	};

	Socket sender = null;

	private static HeartSender instance;

	public static HeartSender getInstance() {
		if (instance == null) {
			synchronized (HeartClient.class) {
				instance = new HeartSender();
			}
		}
		return instance;
	}

	public void send() {
		try {
			sender = new Socket(InetAddress.getLocalHost(), 9090);
			while (true) {
				ObjectOutputStream out = new ObjectOutputStream(sender.getOutputStream());
				Heart obj = new Heart();
				obj.setName("ripperMan");
				obj.setSex("男");
				out.writeObject(obj);
				out.flush();
				System.out.println("已发送...");
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
