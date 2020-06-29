package com.example.design.thread.base;

import cn.hutool.core.date.DatePattern;
import com.example.design.utils.DateUtil;

import java.util.Date;

public abstract class BaseJob extends Thread {
    private long waitTime;

    public BaseJob(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        before();
        exec();
        after();
    }

    protected abstract void exec();

    private void before() {
        String dateTime = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MS_FORMAT);
        if (waitTime > 0) {
            System.out.println(Thread.currentThread().getName() + " is wait. wait time is " + String.valueOf(waitTime) + ". current date time is " + dateTime);
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dateTime = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MS_FORMAT);
        System.out.println(Thread.currentThread().getName() + " run before. " + "current date time is " + dateTime);
    }

    private void after() {
        String dateTime = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MS_FORMAT);
        System.out.println(Thread.currentThread().getName() + " run after. " + "current date time is " + dateTime);
    }
}