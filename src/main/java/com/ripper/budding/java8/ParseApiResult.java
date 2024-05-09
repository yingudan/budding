package com.ripper.budding.java8;



import java.io.*;

/**
 * 解析百度商情返回格式为指定格式
 * @author HuangQing
 * @create 2018/7/2 11:25
 **/
public class ParseApiResult {

	public static void main(String[] args) throws Exception {
		File file = new File("8apienterprisekeyperson.csv");
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"), 50 * 1024 * 1024);
		String line = null;
		int lineNumber = 0;
		// 参数
		String params = null;
		while ((line = reader.readLine()) != null) {
			lineNumber++;
			String result = null;
			if (lineNumber % 2 == 1) { // 参数
				params = line;
			} else { // 返回值
				result = line;
				System.out.println(result);
				// 解析参数和返回值

			}
		}
//		IOUtils.closeQuietly(reader);
//		IOUtils.closeQuietly(fis);

	}

}
