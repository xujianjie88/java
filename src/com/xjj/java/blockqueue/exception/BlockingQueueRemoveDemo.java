package com.xjj.java.blockqueue.exception;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 再来一个取元素，元素没有了，抛异常的代码情况
 */
public class BlockingQueueRemoveDemo {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    class costormer extends Thread {
        @Override
        public void run() {
            queue.remove();
            System.out.println("向队列中取出一个元素，队列剩余：" + queue.size() + "个元素");
        }
    }


    public static void main(String[] args) {
        BlockingQueueRemoveDemo blockingQueueDemo = new BlockingQueueRemoveDemo();
        costormer costormer = blockingQueueDemo.new costormer();
        costormer.start();
    }
}


