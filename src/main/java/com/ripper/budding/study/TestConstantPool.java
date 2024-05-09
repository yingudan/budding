package com.ripper.budding.study;

public class TestConstantPool {

	public static void main(String[] args) {
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		System.out.println(i1 == i2);// 输出false
		// i1,i2分别位于堆中不同的内存空间
		Integer i3 = 1;
		Integer i4 = 1;
		// i3,i4指向常量池中同一个内存空间
		System.out.println(i3 == i4);// 输出true
		// 很显然，i1,i3位于不同的内存空间
		System.out.println(i1 == i3);// 输出false
		String a="666";
		String b="666";
		System.out.println(a==b);
//		StringBuffer sb = new StringBuffer();
//		sb.equals(obj);
		StringBuilder sb = new StringBuilder();
//		sb.equals(obj);
		
	}
}

