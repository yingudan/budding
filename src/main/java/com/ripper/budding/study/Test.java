package com.ripper.budding.study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @author shandowF 
* @date  2018年8月23日 
*/
public class Test {

	// ^[1-9]\\d{3}_(0[1-9]|1[0-2])_(0[1-9]|[1-2][0-9]|3[0-1])+$
	public static void main(String[] args) {
		String str = "sas_dataexchange_gateway_httpproxy_event_2018_07_10";
		// String str = "baike.com.dp";
		// sas_apps_basicinfo_2018_04_07
//		String regEx = "^[1-9]\\d{3}_(0[1-9]|1[0-2])_(0[1-9]|[1-2][0-9]|3[0-1])+$";
		String regEx = "/*[0-9]\\d{3}_(0[1-9]|1[0-2])_(0[1-9]|[1-2][0-9]|3[0-1])+$";
//		String regEx = "/^[1-2]{1}([0-9]{3})_([0-1]{1})([0-9]{1})_(([0-2]){1}([0-9]{1})|([3]{1}[0-1]{1}))$/";
		// String regEx = "baike";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regEx);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		boolean find = matcher.find();
		System.out.println(find);
		// 字符串是否与正则表达式相匹配
		String trim = matcher.replaceAll("").trim();
		System.out.println(trim);

	}

	// String str = "*adCVs*34_a
	// _09_b5*[/435^*&城池()^$$&*).{}+.|.)%%*(*.中国}34{45[]12.fd'*&999下面是中文的字符￥……{}【】。，；’“‘”？";
	// String regEx =
	// "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
	// Pattern p = Pattern.compile(regEx);
	// Matcher m = p.matcher(str);
	// String trim = m.replaceAll("").trim();
	// System.out.println(trim);

}
