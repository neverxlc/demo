package com.example.demo.vo;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("over");
        });
//        System.out.println(thread.getState());
        Thread thread1 = new Thread(()->{
            while (!thread.getState().equals(Thread.State.TERMINATED)) {
                System.out.println(thread.getState());
            }
            System.out.println(thread.getState());
        });
        thread1.start();
        Thread.sleep(1);
        thread.start();


    }
}
