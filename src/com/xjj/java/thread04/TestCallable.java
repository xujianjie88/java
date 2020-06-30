package com.xjj.java.thread04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的第三种方式
 * @author Administrator
 *
 */
public class TestCallable implements Callable<String>{
	
	public TestCallable(String name) {
		this.name = name;
	}

	//FutureTask接受线程的返回值
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> futureTask = new FutureTask<>(new TestCallable("许健杰"));
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}
	
	private String name;

	@Override
	public String call() throws Exception {
		return name+"是一个好人";
	}

}
