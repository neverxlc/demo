package com.example.demo.vo;

import com.example.demo.domain.Book;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ScheduleDemo {

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Lock lock = new ReentrantLock();

    public Lock getLock() {
       lock.newCondition();
       return null;
    }

    public void beepForAnHour(){
        final ScheduledFuture<?> handler = scheduler.scheduleAtFixedRate(this::test
                ,2, 3, TimeUnit.SECONDS);
        scheduler.schedule(()->{
            handler.cancel(true);
        },60 , TimeUnit.SECONDS);
    }

    public synchronized void test(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("beep");
        synchronized (this) {

        }
        synchronized (scheduler) {

        }
    }



    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ScheduleDemo scheduleDemo = new ScheduleDemo();
        scheduleDemo.beepForAnHour();
        scheduleDemo.test();


//        Map<String,String> map = new HashMap<>();
//        map.put("name","xlc");
//        System.out.println(map);
//        map.put("age","12");
//        System.out.println(map.put("age","12"));
//        System.out.println(map.put("age","13"));
//        System.out.println(map.putIfAbsent("age","14"));
//        System.out.println(map.get("age"));
//        System.out.println(Boolean.class.isPrimitive());
//        System.out.println(Integer.class.isPrimitive());
//        System.out.println(Book.class.isPrimitive());
//        System.out.println(int.class.isPrimitive());
//        System.out.println(long.class.isPrimitive());
//        System.out.println(long.class.getDeclaredMethods());
//        System.out.println("**************************");
//        Method[] methods = Book.class.getDeclaredMethods();
//        Book book = new Book();
//        for (Method method:methods) {
//            System.out.println(method.getName());
//            if (method.getName().startsWith("set")) {
//                method.invoke(book, new Object[]{"1"});
//            }
//        }
//        System.out.println("输出book");
//        System.out.println(book);
//        System.out.println("@@@@@@@@@@@@@@@@@@@");
//        Field[] fields = Book.class.getDeclaredFields();
//        for (Field field: fields) {
//            System.out.println(field.getName());
//            field.setAccessible(true);
//            System.out.println(field.get(book));
//        }
//        System.out.println(map);
    }
}
