package com.ripper.budding.design.strategy.normal;

/**
 * 负责管理策略类的类(Manager) 负责和具体的策略类交互 这样的话,具体的算法和直接的客户端调用分离了,使得算法可以独立于客户端独立的变化.
 * 如果使用spring的依赖注入功能,还可以通过配置文件,动态的注入不同策略对象,动态的切换不同的算法.
 */
public class Context {

	/**
	 * 当前采用的算法对象
	 */
	private Strategy strategy;

	/**
	 * 1).可以通过构造器来注入
	 */
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 2).可以通过set方法来注入
	 */
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 打印报价(具体业务) 根据当前策略,执行该策略所对应的计算方法 不同策略,执行不同的计算方法
	 */
	public void printPrice(double standardPrice) {
		double resultPrice = this.strategy.getPrice(standardPrice);
		System.out.println("您该报价: " + resultPrice);
	}

}
