package com.xjj.java.blockqueue.noblock;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * 由此可见poll()方法是队列没有数据获取时不阻塞，不抛异常返回null的一种方式。
 */
public class BlockingQueuePollDemo {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    class costormer extends Thread {
        @Override
        public void run() {
            Object obj = queue.poll();
            if (obj == null) {
                System.out.println("队列无数据！");
            } else {
                System.out.println("向队列中取出一个元素，队列剩余：" + queue.size() + "个元素");
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueuePollDemo blockingQueueDemo = new BlockingQueuePollDemo();
        costormer costormer = blockingQueueDemo.new costormer();
        costormer.start();
    }
}
