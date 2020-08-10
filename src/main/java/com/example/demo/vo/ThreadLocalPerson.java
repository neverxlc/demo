package com.example.demo.vo;

import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalPerson {

//    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();


    public static void setPerson(String name){
        threadLocal.set(name);
    }

    public static String getPerson() {
       return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }


    public static void main(String[] args) throws InterruptedException {

//        int size = 0;
//        System.out.println(size);
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        Lock lock = new ReentrantLock();
//        Condition condition = lock.newCondition();
        Semaphore semaphore = new Semaphore(1,true);
        ThreadLocalPerson.setPerson("hctym");
        Thread thread = new Thread(()->{
//            ThreadLocalPerson.setPerson("xlc");
            System.out.println(Thread.currentThread().getName()+"===" + ThreadLocalPerson.getPerson());
//            countDownLatch.countDown();
//            condition.signalAll();
                semaphore.release();

        });
        thread.start();
//        Thread.sleep(1000);
        thread.join();
//        thread.setPriority();
//        countDownLatch.await();
//        condition.await();

        semaphore.acquire();
        System.out.println(Thread.currentThread().getName()+"===" + ThreadLocalPerson.getPerson());

    }
}
