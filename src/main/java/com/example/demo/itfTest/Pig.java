package com.example.demo.itfTest;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Pig implements Animals {
    @Override
    public void eat() {

        System.out.println("ear pig");
    }


    public static void main(String[] args) {
//        System.out.println(System.getProperty("java.home"));

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        for(int i = 0;i < 20;i ++) {
            queue.offer(i+"");
        }
        System.out.println(queue);
        for (int j = 0;j < 20;j ++) {
//            System.out.println(queue.remove());
//            System.out.println(queue.poll());
//            System.out.println(queue.element());
            System.out.println(queue.peek());
        }
        System.out.println(queue);
    }
}
