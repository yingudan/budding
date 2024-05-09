package com.ripper.budding.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class TestMap {
	
	public static void test(String ...names){
		for(String str:names){
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap();
		map.put("郑州", "河南");
		map.put("长沙", "湖南");
		map.put("map", "小奶狗");
//		List<String>  ww = new ArrayList<>();
		Set<String> set = map.keySet(); // 取出所有的key值
		for (String key : set) {
//			ww.add(key);
			System.out.println("第一种：" + map.get(key));
		}
		set.clear();
		for (String key : set) {
//			ww.add(key);
			System.out.println("第er种：" + map.get(key));
		}
//		String[] array =StringUtils.join(iterable, ",")
//		String[] array=ww.toArray(new String[ww.size()]);
//		test(array);
		// 第一種
//
//		// 第二种
//		Set<Map.Entry<String, String>> entryseSet = map.entrySet();
//		for (Map.Entry<String, String> entry : entryseSet) {
//			System.out.println("第二种：" + entry.getKey() + ":" + entry.getValue());
//		}
//
//		// 第三种
//		Iterator it = map.keySet().iterator();
//		while (it.hasNext()) {
//			 String key = (String) it.next();
////			String value = map.get(it.next());
//			System.out.println("第三种：" + key);
//		}
	}

}
