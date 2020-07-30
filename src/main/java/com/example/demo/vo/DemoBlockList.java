package com.example.demo.vo;

import org.apache.tomcat.jni.Address;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class DemoBlockList {

    public static void main(String[] args) throws UnknownHostException {
        Stream.of(InetAddress.getAllByName("www.taobao.com"))
                .forEach(System.out::println);
        //联通  www.baidu.com/61.135.169.121
        //联通  www.baidu.com/61.135.169.125
        //联通  www.baidu.com/2408:80f0:410c:1c:0:ff:b00e:347f
        //联通  www.baidu.com/2408:80f0:410c:1d:0:ff:b07a:39af

// 联通       www.taobao.com/121.29.9.227
// 联通       www.taobao.com/119.249.58.219
// 联通       www.taobao.com/121.29.9.226
// 联通       www.taobao.com/2408:871a:2000:6:3:0:0:3f6
// 联通       www.taobao.com/2408:871a:1120:5002:3:0:0:3f9
// 联通       www.taobao.com/2408:871a:1120:5002:3:0:0:3fa
    }


    public static void main1(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);

        Thread t1 = new Thread(()->{
            for(int i=0;i<100;i++) {
                System.out.println("生产："+i);
                try {
                    if (i%10 == 5)
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.offer(i);
            }
        });

        Thread t2 = new Thread(()->{
            while (true) {
                Object o = null;
                try {
//                    if (blockingQueue.size() == 20)
                    o = blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("消费："+ o);
            }
        });

        t1.start();
        t2.start();
    }
}
