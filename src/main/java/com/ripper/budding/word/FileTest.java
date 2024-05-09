package com.ripper.budding.word;

import java.io.File;
import java.io.FileOutputStream;

public class FileTest {
		
	
	public void  test(String pathname) throws Exception{
		File f1 =new File("E:/ccc/");
		f1.mkdirs();
//		FileOutputStream outputStream = new FileOutputStream(f1); 
//		// 写入数据 
////		outputStream.write(data); 
//		// 关闭输出流 
//		outputStream.close(); 
//		System.out.println(f1);

	}
	
	public static void main(String[] args) throws Exception {
		FileTest fy = new FileTest();
		fy.test("aa");
	}
}
