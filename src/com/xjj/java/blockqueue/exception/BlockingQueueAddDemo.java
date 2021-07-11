package com.xjj.java.blockqueue.exception;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ָ���˴洢10�����֣�Ȼ��Ҫ�洢11������ô�ͻᱨ�����Կ���add()�����Ǵ洢���˾����쳣�ķ�ʽ
 */
public class BlockingQueueAddDemo {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);
    //������
    class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < queueSize + 1; i++) {
                queue.add(i);
                System.out.println("����������Ԫ�أ�����ʣ��ռ䣺" + (queueSize - queue.size()));
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueueAddDemo blockingQueueDemo = new BlockingQueueAddDemo();
        Producer producer = blockingQueueDemo.new Producer();
        producer.start();
    }
}
