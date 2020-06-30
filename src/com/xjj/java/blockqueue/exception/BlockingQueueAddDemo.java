package com.xjj.java.blockqueue.exception;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 指定了存储10个数字，然后要存储11个，那么就会报错，可以看出add()方法是存储满了就抛异常的方式
 */
public class BlockingQueueAddDemo {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);
    //生产者
    class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < queueSize + 1; i++) {
                queue.add(i);
                System.out.println("向队列中添加元素，队列剩余空间：" + (queueSize - queue.size()));

            }
        }
    }

    public static void main(String[] args) {
        BlockingQueueAddDemo blockingQueueDemo = new BlockingQueueAddDemo();
        Producer producer = blockingQueueDemo.new Producer();
        producer.start();
    }
}
