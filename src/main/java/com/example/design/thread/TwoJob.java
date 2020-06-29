package com.example.design.thread;

import com.example.design.thread.base.BaseJob;

import java.util.function.Consumer;

public class TwoJob extends BaseJob {

    private Consumer<String> consumer;

    public TwoJob(long waitTime, Consumer<String> consumer) {
        super(waitTime);
        this.consumer = consumer;
    }

    @Override
    protected void exec() {
        System.out.println("two job is exec.");
        consumer.accept("two job");
    }
}
