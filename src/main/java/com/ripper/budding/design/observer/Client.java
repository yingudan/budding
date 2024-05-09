package com.ripper.budding.design.observer;

import java.util.Vector;

public class Client {
	public static void main(String[] args) {
		Vector students = new Vector();
		Teacher t = new Teacher();
		for (int i = 0; i < 10; i++) {
			Student st = new Student("ygd" + i, t);
			students.add(st);
			t.attach(st);
		}
		t.setPhone("88803807");
		for (int i = 0; i < 10; i++)
			((Student) students.get(i)).show();
		t.setPhone("88808880");
		for (int i = 0; i < 10; i++)
			((Student) students.get(i)).show();
	}
}
