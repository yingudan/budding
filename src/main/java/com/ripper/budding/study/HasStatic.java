package com.ripper.budding.study;

public class HasStatic {
	private static int x = 100;
	public static int func (){
	    try{
	        return 1;
	    }catch (Exception e){
	        return 2;
	    }finally{
	        return 3;
	    }
	}
	public static void main(String args[]) {
	System.out.println(func());	
//		HasStatic hs1 = new HasStatic();
//		hs1.x++;
//		HasStatic hs2 = new HasStatic();
//		hs2.x++;
//		hs1 = new HasStatic();
//		hs1.x++;
//		HasStatic.x--;
//		System.out.println("x=" + x);
	}
}