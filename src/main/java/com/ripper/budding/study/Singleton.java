package com.ripper.budding.study;

import java.io.Serializable;

public class Singleton implements Serializable {
	private static final long serialVersionUID = -1676743667621517791L;

	private Singleton() {
		System.out.println("Singleton is create");
	}
	Integer a=11;
	
	private final static Singleton instance = new Singleton();

	public static Singleton getSingleton() {
		return instance;
	}

	public Object readResolve() {
		return instance;
	}
	
	
	// private static final long serialVersionUID = 1553550427239449308L;
	//
	// private Singleton() {
	// System.out.println("创建单列");
	// }
	//
	// private final static class SingletonHandler {
	// private final static Singleton singleton = new Singleton();
	// }
	//
	// public static Singleton getSingleton() {
	// return SingletonHandler.singleton;
	// }
	//
	// public Object readResolve() {
	// return SingletonHandler.singleton;
	// }
}