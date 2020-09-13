package com.example.demo.vo;

import com.example.demo.controller.ApiInfoController;
import com.example.demo.itfTest.Animals;
import org.springframework.boot.system.JavaVersion;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class BaseReponse implements Serializable {

    private ResponseHeader responseHeader = new ResponseHeader();

    public BaseReponse() {
    }

    public BaseReponse(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public static BaseReponse ok() {
        return new BaseReponse();
    }

    public static BaseReponse failure(String resultCode, String resultMessage){
        ResponseHeader responseHeader = new ResponseHeader(false, resultCode, resultMessage);
        return new BaseReponse(responseHeader);
    }


    private static final AtomicIntegerArray ID = new AtomicIntegerArray(18);
    public static void main(String[] args) {


//        new Timer("test-timer", true).schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("this is demo");
//            }
//        }, 100, 100);


        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("hhhhhhhhh");
        },200, 100, TimeUnit.MILLISECONDS);

//        try {
//            Thread.currentThread().join(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Annotation[]  annotations = ApiInfoController.class.getAnnotations();
//        for (Annotation annotation : annotations)
//        System.out.println(annotation.annotationType().getName());

//        String path = "https://baike.baidu.com/item/%E8%97%9C%E8%8B%8B/7696441?fr=aladdin";
//        String[] pathSplit = path.split("/", 0);
//
//        for (String str: pathSplit) {
//            System.out.println(str);
//        }



//        JavaVersion.getJavaVersion().name();
        System.out.println(JavaVersion.getJavaVersion().toString());
        /*String queryParam = "name=xlc&age=20&sex=man";
        StringTokenizer stringTokenizer = new StringTokenizer(queryParam,"&");
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            System.out.println(token);
        }*/


//        System.out.println(ID.getAndIncrement(1));
//        System.out.println(ID.getAndIncrement(1));
//        System.out.println(ID.getAndIncrement(1));
//        System.out.println(ID.getAndIncrement(1));
//        System.out.println(ID.getAndIncrement(2));
//        System.out.println(ID.getAndIncrement(2));
//
//        System.out.println(ID.getAndIncrement(2));

    }
}
