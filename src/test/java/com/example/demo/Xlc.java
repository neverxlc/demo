package com.example.demo;

import java.util.Properties;
import java.util.concurrent.Semaphore;

public class Xlc {

    public static void main(String[] args) throws InterruptedException {

//        String osName = System.getProperty("os.name");
//        String platform = System.getProperty("os.arch");
//        System.out.println(osName);
//        System.out.println(platform);
//        System.out.println(System.getProperties());
//        Properties properties = System.getProperties();
//        properties.forEach((k,v)->{
//            System.out.println(String.format("%s-----:%s",k,v));
//        });


//        Thread thread = new Thread(()->{
////            try {
////                Thread.sleep(1000L);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            System.out.println(Thread.currentThread().getName()+"     aaaa");
////        });
////        Thread thread1 = new Thread(()->{
////            System.out.println(Thread.currentThread().getName()+"      bbbbb");
////        });
////        thread.start();
////        thread1.start();
////        thread1.join();
////        thread.join();
////        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(()->{
            SemaproneTest semaproneTest = new SemaproneTest();
            semaproneTest.acquire();
        });
        t1.start();
        Thread t2 = new Thread(()->{
            SemaproneTest semaproneTest = new SemaproneTest();
            semaproneTest.acquire();
        });
        t2.start();
    }



     static class SemaproneTest{
        Semaphore semaphore = new Semaphore(1);

        private void acquire(){
            try {
                int a = 10;
                System.out.println(a);
                semaphore.acquire();
                a = 20;
                System.out.println(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void relase(){
            semaphore.release();
        }

    }

}
