package com.ripper.budding.design.observer;

/**
 * 建立目标
 */
public interface Subject {
	 void attach(Observer o);// 观察操作

	 void detach(Observer o);

	 void notice();
	
	

}
