package com.ripper.budding.study;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;


/**
 *  一辆载西瓜的小货车不幸翻车了，有个人去哄抢
 * 假设共10个西瓜，这人每次抢一个西瓜最多花1000ms，当然，
 * 他每次抢的时间肯定都不同，所以我们用随机数表示。
 * 维护次序者（城管）2000ms后赶到，
 * 随即中断哄抢线程。看这人最后抢到几个西瓜？
 */
class Looting implements Callable<String> {
	private int wmQuantities; // 西瓜总数
	
	private int milliseconds; // sleep时长的上限

	public Looting(int wmQuantities, int milliseconds) {//初始化西瓜和睡眠时长
		this.wmQuantities = wmQuantities;
		this.milliseconds = milliseconds;
		out.println("共" + wmQuantities + "个西瓜");
	}

	@Override
	public String call() throws Exception {
		int wmCount = 0; // 抢到的西瓜计数
		Random random = new Random(); // 时长随机数

		while (++wmCount <= wmQuantities) {
			out.println("抢到" + wmCount + "个西瓜...");
			Thread.sleep(random.nextInt(milliseconds)); // 每次搬抢西瓜所花时间是不同的
		}

		return ("本次" + wmQuantities + "个西瓜中，抢了" + (wmCount - 1) + "个。");
	}
}

public class LootWatermelon {
	public static void main(String[] args) throws Exception, ExecutionException {
		//1进入主函数
		Looting looting = new Looting(10, 1000);//初始化西瓜 和 睡眠长度
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();//初始化
		
		Future<String> future = executorService.submit(looting);
		
		try {
			future.get(2000, TimeUnit.MILLISECONDS); // 假设维护次序人员2000ms后赶到，中断哄抢线程
			out.println("事件正常结束。");
		} catch (Exception e) {
			out.println("事件被中断：" + future.cancel(true));//事件中断处理
		}
		executorService.shutdownNow(); // 关闭ExecutorService
	}
}