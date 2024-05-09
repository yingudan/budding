package com.ripper.budding.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Test extends Thread {

	public void run(String a) {
		super.run();
		System.out.println("这个是线程"+a);
		while (true) {
			String[] pwds = { "123456", "sdsdsds", "dsdsds", "dsdsds", "rwerw", "qweqwe", "hghghgh", "dsfsdger",
					"rtredsds", "dsadasdas" };
			System.out.println(pwds[(int) (Math.random() * 10)]);
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Test().run(UUID.randomUUID().toString());
		new Test().run(UUID.randomUUID().toString());

		// new Test().start();
		 List list1 = new ArrayList();
		// list1.add("1111");
		// list1.add("2222");
		// list1.add("3333");
		//
		// List list2 = new ArrayList();
		// list2.add("3333");
		// list2.add("4444");
		// list2.add("5555");
		//
		// // 并集
		// // list1.addAll(list2);
		// // 交集
		// // list1.retainAll(list2);
		// // 差集
		// // list1.removeAll(list2);
		// List list3 = new ArrayList();
		// // 无重复并集
		// list2.removeAll(list1);
		// // list1.addAll(list2);
		// // list3.addAll(list1);
		// // list3.addAll(list2);
		// // list3.removeAll(list1);
		//
		// Iterator<String> it = list2.iterator();
		// while (it.hasNext()) {
		// System.out.println(it.next());
		//
		// }

		// System.out.println("-----------------------------------\n");
		// printStr(list1);
	}
}
