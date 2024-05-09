package com.ripper.budding.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/** 
* @author shandowF 
* @date  2018年8月9日 
*/
public class LinkedHashMap {

	// private LinkedBlockingQueue<Integer> queue = new
	// LinkedBlockingQueue<Integer>();

	// private BlockingQueue<Integer> queue ;

	private volatile boolean isRunning = true;

	public static List<Integer> LIST = new CopyOnWriteArrayList<>();

	// 用户id 对应用户选择的策略
	public static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		LinkedHashMap test = new LinkedHashMap();
		Producer producer = test.new Producer();
		Producer producer2 = test.new Producer();
		Consumer consumer = test.new Consumer();
		Consumer consumer2 = test.new Consumer();

		producer.start();
		consumer.start();
		consumer2.start();
		producer2.start();
	}

	class Consumer extends Thread {

		@Override
		public void run() {
			consume();
		}

		private void consume() {
			while (isRunning) {
				try {
					Map<Integer, Integer> themap = map;
					Integer integer = themap.get(3);
					if (integer != null) {
						System.out.println("获取到了" + themap.size());
						System.out.println(this.getName());
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		}
	}

	class Producer extends Thread {

		Integer number = 0;

		@Override
		public void run() {
			produce();
		}

		private void produce() {
			while (true) {
				number++;
				try {
					sleep(100l);// 睡0.1s

					map.put(number, number);
					// LIST.add(number);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
				if (number == 1000) {
					break;
				}
			}
		}
	}
}
