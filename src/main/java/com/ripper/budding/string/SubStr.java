package com.ripper.budding.string;

public class SubStr {
	/**
	 * 如果大于多少个字符的话 后面的以...结束
	 * 
	 * @param str
	 *            原字符串
	 * @param len
	 *            超过多少个就开始 以。。。代替 默认15
	 * @param endStr
	 *            后面的字符以 endStr 代替 默认...
	 * @return 新字符串
	 */
	public static String getSd(String str, int len, String endStr) {
		if (str == null || "".equals(str)) {
			return "";
		}
		if (len == 0) {
			len = 15;
		}
		if (endStr == null || "".equals(endStr)) {
			endStr = "...";
		}

		if (str.length() > len) {
			str = str.substring(0, len) + endStr;
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(SubStr.getSd("就喀什的金卡和点就开始打就开始", 5, ""));
		//// Test22 test22 = new Test22();
		//// System.out.println(Test22.h);
		// String a="/api/bond/getBond.json 或 /api/bond/getBond.csv";
		// System.out.println(a.split("或")[0].toString());
	}
}
