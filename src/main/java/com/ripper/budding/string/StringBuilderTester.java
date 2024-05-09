package com.ripper.budding.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringBuilderTester {
	private static final String base = " base string. ";
	private static final int count = 2000000;

	public static void stringTest() {
		long begin, end;
		begin = System.currentTimeMillis();
		String test = new String(base);
		for (int i = 0; i < count / 100; i++) {
			test = test + " add ";
		}
		end = System.currentTimeMillis();
		System.out.println((end - begin) + " millis has elapsed when used String. ");
	}

	public static void stringBufferTest() {
		long begin, end;
		begin = System.currentTimeMillis();
		StringBuffer test = new StringBuffer(base);
		for (int i = 0; i < count; i++) {
			test = test.append(" add ");
		}
		end = System.currentTimeMillis();
		System.out.println((end - begin) + " millis has elapsed when used StringBuffer. ");
	}

	public static void stringBuilderTest() {
		long begin, end;
		begin = System.currentTimeMillis();
		StringBuilder test = new StringBuilder(base);
		for (int i = 0; i < count; i++) {
			test = test.append(" add ");
		}
		end = System.currentTimeMillis();
		System.out.println((end - begin) + " millis has elapsed when used StringBuilder. ");
	}

	public static String appendItemsToStringBuiler(List list) {
		StringBuilder b = new StringBuilder();

		for (Iterator i = list.iterator(); i.hasNext();) {
			b.append(i.next()).append(" ");
		}

		return b.toString();
	}

	public static void addToStringBuilder() {
		List list = new ArrayList();
		list.add(" I ");
		list.add(" play ");
		list.add(" Bourgeois ");
		list.add(" guitars ");
		list.add(" and ");
		list.add(" Huber ");
		list.add(" banjos ");

		System.out.println(StringBuilderTester.appendItemsToStirngBuffer(list));
	}

	public static String appendItemsToStirngBuffer(List list) {
		StringBuffer b = new StringBuffer();

		for (Iterator i = list.iterator(); i.hasNext();) {
			b.append(i.next()).append(" ");
		}

		return b.toString();
	}

	public static void addToStringBuffer() {
		List list = new ArrayList();
		list.add(" I ");
		list.add(" play ");
		list.add(" Bourgeois ");
		list.add(" guitars ");
		list.add(" and ");
		list.add(" Huber ");
		list.add(" banjos ");

		System.out.println(StringBuilderTester.appendItemsToStirngBuffer(list));
	}

	public static void main(String[] args) {
		stringTest();
		stringBufferTest();
		stringBuilderTest();
		addToStringBuffer();
		addToStringBuilder();
	}
}