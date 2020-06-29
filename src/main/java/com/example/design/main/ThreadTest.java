package com.example.design.main;

import com.example.design.thread.OneJob;
import com.example.design.thread.TwoJob;
import com.example.design.thread.base.BaseJob;

import java.util.concurrent.CountDownLatch;

public class ThreadTest {
    private final static long waitTime = 3000L;

    /**
     * 计数器
     * 1、构造时设定初始值
     * 2、countDown()，使初始值减一
     * 3、await()，如果初始值不为0，那么一直等待
     */
    private final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(2);

    public static void main(String[] args) {
        System.out.println("main exec start.");
        BaseJob job1 = new OneJob(waitTime, (name) -> COUNT_DOWN_LATCH.countDown());
        job1.start();
        BaseJob job2 = new TwoJob(waitTime, (name) -> COUNT_DOWN_LATCH.countDown());
        job2.start();
        try {
            COUNT_DOWN_LATCH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main exec end.");
    }
}
