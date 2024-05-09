package com.ripper.budding.string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomNumberStr {
	/**
	 * 获取四位随机数字字符串，且四位数字不重复
	 * 
	 * @return Set<Integer>
	 */
//	private static Set<String> getRandomNumberStr() {
//		// SET集合
//		Set<String> set = new HashSet<String>();
//
//		while (set.size() < 1) {
//			Random r = new Random();
//
//			// nextInt(n)返回 0<= x <n之间均匀分布的 int 值
//			while (set.size() < 1) {
//				set.add(Math.random()*25+65);
//			}
//		}
//
//		return set;
//	}

	public static String getRandomString2(int length){
		
		Long stTime=System.currentTimeMillis();
		Random random=new Random();
	    StringBuffer sb=new StringBuffer();
	    for(int i=0;i<length;i++){
	       int number=random.nextInt(3);
	       long result=0;
	       switch(number){
	          case 0:
	              result=Math.round(Math.random()*25+65);
	              sb.append(String.valueOf((char)result));
	              break;
	         case 1:
	             result=Math.round(Math.random()*25+97);
	             sb.append(String.valueOf((char)result));
	             break;
	         case 2:     
	             sb.append(String.valueOf(new Random().nextInt(10)));
	             break;
	        }
	   
	     }
	    System.out.println(System.currentTimeMillis()-stTime);
	     return sb.toString();
	 }
	
	/**
	 * 测试
	 */
	public static void main(String[] args) {
//		Set<Integer> set = getRandomNumberStr();
//
//		Iterator<Integer> iterator = set.iterator();
//		String numberStr = "";
//
//		while (iterator.hasNext()) {
//			numberStr += iterator.next();
//		}
//		System.out.println(numberStr);
//		System.out.println(getRandomString2(1));
		
		
	}
}
