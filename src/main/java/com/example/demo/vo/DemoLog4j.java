package com.example.demo.vo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoLog4j {
//    Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();

        Thread t1 = new Thread(()->{
            String name = "许林创123123";
            logger.warn("你好,{}", name);
            logger.info("File name is C:\\\\{}.", "file.zip");
//            countDownLatch.countDown();
        });
        t1.start();
        logger.info("Hello World");
    }
}
