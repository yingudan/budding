package com.ripper.budding.string;

import java.io.IOException;

/**
 * 对称
 * @author UJU205
 *
 */
public class StrSmp {
	
	public static void main(String[] args) throws IOException {
		int[] ai1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
		int[] ai2 = {40,67,69,57,4,56,56,57,57,9,15,4,77,77,77,5,5,16,70,74,74,62};
		
		String[] as2 = new String[100];
		String s = "";
		int i = 0, n = 0;
		char c = '*';
		while(n <= 99){
			i = (int)c;
			as2[n] = String.valueOf(c);
			i++;
			n++;
			c = (char)i;
		}
		for (int j = 0; j < ai1.length; j++) {
			s += as2[ai2[ai1[j]]];
		}
		System.out.println(s);
		s="123";
		System.out.println(new StringBuffer(s).reverse().toString());
		String str = "cmd.exe /c explorer " + new StringBuffer(s).reverse().toString();
//		Runtime.getRuntime().exec(str);
	}

	

}
