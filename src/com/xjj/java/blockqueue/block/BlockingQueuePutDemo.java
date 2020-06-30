package com.xjj.java.blockqueue.block;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 可以看到存储满了就会一直阻塞等待，直到队列元素被取出才会停止阻塞，由此可见存储数据的put()是有阻塞功能的。
 */
public class BlockingQueuePutDemo {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    //生产者
    class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < queueSize + 1; i++) {

                try {
                    queue.put(i);
                    System.out.println("向队列中添加元素，队列剩余空间：" + (queueSize - queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueuePutDemo blockingQueueDemo = new BlockingQueuePutDemo();
        Producer producer = blockingQueueDemo.new Producer();
        producer.start();
    }

}
