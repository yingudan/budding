package com.ripper.budding.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Write Obj to file
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
		oos.writeObject(Singleton.getSingleton());
		// Read Obj from file
		File file = new File("tempFile");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Singleton newInstance = (Singleton) ois.readObject();
		// 判断是否是同一个对象
		System.out.println(newInstance == Singleton.getSingleton());
		System.out.println(newInstance.equals(Singleton.getSingleton()));
//		SerializableDemo1.class.newInstance();
	}
}