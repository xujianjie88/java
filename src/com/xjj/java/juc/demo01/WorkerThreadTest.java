package com.xjj.java.juc.demo01;

import com.google.common.collect.Lists;

import java.util.List;

public class WorkerThreadTest {

    /**
     * ���Զ��̻߳ع�(�ֲ�ʽ����):
     * ����:�߳�1������,�߳�2,3�ع�
     *
     * @param args
     */
    public static void main(String[] args) {
        WorkerThread worker1 = new WorkerThread("worker1", 3, false);
        WorkerThread worker2 = new WorkerThread("worker2", 5, false);
        WorkerThread worker3 = new WorkerThread("worker3", 1, false);

        worker1.start();
        worker2.start();
        worker3.start();

        List<WorkerThread> workerThreadList = Lists.newArrayList();
        workerThreadList.add(worker1);
        workerThreadList.add(worker2);
        workerThreadList.add(worker3);
        while (true) {
            for (WorkerThread workerThread : workerThreadList) {
                if (workerThread.getResult()) {
                    System.exit(0);
                }
            }
        }
    }

}
