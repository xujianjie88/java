package com.xjj.java.thread04;

import java.util.concurrent.Executor;

/***
 * 启动线程的第四种方式
 * @author Administrator
 *
 */
public class TestExecutor implements Executor{
	
	
	public static void main(String[] args) {
		new TestExecutor().execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("我是一个好人");
			}
		});
	}

	@Override
	public void execute(Runnable command) {
		command.run();
	}

}
