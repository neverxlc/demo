package com.example.demo.async;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TaskOfSync {

    public static Random random = new Random();

    public void doTaskOne() throws InterruptedException {
        System.out.println("开始做任务一");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (endTime - startTime) + "毫秒");
    }

    public void doTaskTwo() throws InterruptedException {
        System.out.println("开始做任务二");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (endTime - startTime) + "毫秒");
    }

    public void doTaskThree() throws InterruptedException {
        System.out.println("开始做任务三");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (endTime - startTime) + "毫秒");
    }
}
