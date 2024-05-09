package com.ripper.budding.design.strategy.nofielse;

/**
 * 策略模式 这四个类都实现了接口PaperColor， 我们再定义一个MyPaper的类（此类具有类似负载均衡的作用，
 * 分按照不同的请求分别调用跟前面4个类中的一个）。 这样就把if...else...屏蔽掉了。
 * 
 * @author shandowF
 * @date 2018年1月10日
 */
public class NoIfElse {
	public static void main(String args[]) {
		MyPaper myPaper = new MyPaper(new White());
		myPaper.choicePen();
	}
}

interface PaperColor {
	public void getPenColor();
}

class White implements PaperColor {
	public void getPenColor() {
		System.out.println("You need a white pen!");
	}
}

class Red implements PaperColor {
	public void getPenColor() {
		System.out.println("You need a red pen!");
	}
}

class Blue implements PaperColor {
	public void getPenColor() {
		System.out.println("You need a blue pen!");
	}
}

class Black implements PaperColor {
	public void getPenColor() {
		System.out.println("You need a black pen!");
	}
}

class MyPaper {
	private PaperColor paperColor;

	public MyPaper(PaperColor paperColor) {
		this.paperColor = paperColor;
	}

	public PaperColor getPaperColor() {
		return this.paperColor;
	}

	public void choicePen() {
		this.paperColor.getPenColor();
	}
}
