package com.example.demo.async;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Component
public class TaskOfAsync {

    public static Random random = new Random();

    @Value(value = "${com.hctym.email}")
    private String email;

    public void doTask(){
        System.err.println(email);
    }

    @Async
    public Future<String> doTaskOne() throws InterruptedException {
        System.out.println("开始做任务一");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (endTime - startTime) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> doTaskTwo() throws InterruptedException {
        System.out.println("开始做任务二");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (endTime - startTime) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThree() throws InterruptedException {
        System.out.println("开始做任务三");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (endTime - startTime) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }
}
