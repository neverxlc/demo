package com.example.demo.spi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task{

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private Object object = new Object();

    public List<String> list = new ArrayList<>();


    public void write(String number){
//        synchronized (object) {
//            list.add(number);
//            object.notifyAll();
//        }


        lock.lock();
        try {
            list.add(number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void read(){
//        synchronized (object) {
//            System.out.println("read pre "+list);
//            try {
//                object.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("read post "+list);
//        }
        lock.lock();
        try {
            System.out.println("pre"+list);
            condition.await();
            System.out.println("post"+list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Task task = new Task();
        Thread t1 = new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+"pre await ");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.write("11212");
            System.out.println("is over");
            countDownLatch.countDown();
        });
        Thread t2 = new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+" pre signalAll");
            task.read();
            System.out.println(Thread.currentThread().getName()+" post signalAll");
            countDownLatch.countDown();
        });
        t1.start();
        t2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是测试");
    }




    static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(100);
    public static void main1(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(()->{
            add();
            countDownLatch.countDown();
        });
        t1.start();

        Thread t2 = new Thread(()->{
            take();
            countDownLatch.countDown();
        });
        t2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("读取数据完成");
    }


    public static void add(){
        for (int i=0;i<5;i++) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("start add");
            boolean flag =  blockingQueue.offer(i);
            System.out.println("add   " + (flag?"成功":"失败"));
        }
    }


    public static void take(){
        while(true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer data = null;
            try {
                data = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("读取数据"+data);
            System.out.println(blockingQueue.isEmpty());
        }
    }
}
