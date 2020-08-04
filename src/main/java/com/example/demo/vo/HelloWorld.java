package com.example.demo.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class HelloWorld {


    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
//        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t1 = new Thread(()->{
            String name = "许林创111";
            logger.warn("你好,{}", name);
            logger.info("File name is C:\\\\{}.", "file.zip");
//            countDownLatch.countDown();
        });
        t1.start();
//        countDownLatch.await();

        logger.info("Hello World");
    }
}
