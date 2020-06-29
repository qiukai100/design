package com.example.design.thread;

import com.example.design.thread.base.BaseJob;

import java.util.function.Consumer;

public class OneJob extends BaseJob {

    private Consumer<String> consumer;

    public OneJob(long waitTime, Consumer<String> consumer) {
        super(waitTime);
        this.consumer = consumer;
    }

    @Override
    protected void exec() {
        System.out.println("one job is exec.");
        consumer.accept("one job");
    }
}
