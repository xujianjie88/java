package com.xjj.java.blockqueue.noblock;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 满了的情况不会抛出异常，也不会阻塞，这种就是成功存储就返回true，队列满了不能存储就返回false了
 */
public class BlockingQueueOfferDemo {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    //生产者
    class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < queueSize + 1; i++) {
                Boolean issuccess = queue.offer(i);
                if (issuccess) {
                    System.out.println("向队列中添加元素，队列剩余空间：" + (queueSize - queue.size()));
                } else {
                    System.out.println("队列已满！");
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueueOfferDemo blockingQueueDemo = new BlockingQueueOfferDemo();
        Producer producer = blockingQueueDemo.new Producer();
        producer.start();
    }
}
