package com.xjj.java.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 测试使用线程池的效率
 * @author Administrator
 *
 */
public class TestThreadPool02 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Long start = System.currentTimeMillis();
		final List list = new ArrayList<>();
		ExecutorService executorService = Executors.newFixedThreadPool(1);//启动固定数量的
		//Executors.newCachedThreadPool(threadFactory);//按需分配线程池
		for(int i=0;i<100000;i++) {
			final int j = i;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					list.add(j);
				}
			});
		}
		//输出结果：88，  100000
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);//这句话和join的类似
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(list.size());
	}

}
