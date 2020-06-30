package com.xjj.java.blockqueue.block;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 当前队列一个元素没有，取数据的时候就被阻塞一直等待了，程序一直没有退出操作，由此可见take()是取出阻塞操作的
 */
public class BlockingQueueTakeDemo {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    class costormer extends Thread {
        @Override
        public void run() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("向队列中取出一个元素，队列剩余：" + queue.size() + "个元素");
        }
    }

    public static void main(String[] args) {
        BlockingQueueTakeDemo blockingQueueDemo = new BlockingQueueTakeDemo();
        costormer costormer = blockingQueueDemo.new costormer();
        costormer.start();
    }
}
