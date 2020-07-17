package com.example.demo.spi;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledDemo {

     final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Demo", true));


    public void beepForAnHour(){
        final ScheduledFuture<?> handler = scheduler.scheduleAtFixedRate(()->{
            System.out.println("beep");
        },10, 10, TimeUnit.SECONDS);
        scheduler.schedule(()->{
            handler.cancel(true);
        },60 , TimeUnit.SECONDS);
    }
//    public void deday(){
//        System.out.println(Thread.currentThread().getName());
//        scheduler.scheduleWithFixedDelay(()->{
//            System.out.println(Thread.currentThread().getName());
//        }, 1000, 2000, TimeUnit.MILLISECONDS);
//        System.out.println("asasad");
//    }

    public static void main(String[] args) {
        ScheduledDemo scheduledDemo = new ScheduledDemo();
//        scheduledDemo.deday();
        scheduledDemo.beepForAnHour();
    }





    public static class Demo1{


        public void main(){

//            demo.scheduleAtFixedRate(this::test,
//                    3000,1000,
//                    TimeUnit.MILLISECONDS);
        }

        public void test(){
            System.out.println(Thread.currentThread().getName());
        }

    }
}
