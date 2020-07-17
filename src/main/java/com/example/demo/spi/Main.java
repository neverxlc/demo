package com.example.demo.spi;

import io.micrometer.core.instrument.util.NamedThreadFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

public class Main {



    public static void main(String[] args) {
        ServiceLoader<SPIService> serviceLoader = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            SPIService spiService = iterator.next();
            spiService.execute();
        }
        try {
            Class<?> clazz = Class.forName("com.example.demo.spi.impl.SPIAServiceImpl", false, Main.class.getClassLoader());
//            SPIService p = SPIService.class.cast(clazz.newInstance());
            SPIService p = (SPIService) clazz.newInstance();
            p.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    public static void main2(String[] args) {
        long a = 10;
        int b = 10;
        System.out.println(a == b);
        a = 100;b=100;
        System.out.println(a == b);
        a = 40000;b=40000;
        System.out.println(a ==b);
    }


    static String aa(Function<Integer,String> function, int b){
        System.out.println("aa=======>"+b);
        return function.apply(b);
    }

    static String hia(Person person,String name){
        return person.hi(name);
    }

    public static void main33(String[] args) {
        System.out.println(hia(name->{
            return "nihao->"+name;
        },"xulinchuang"));
    }


//    private Lock lock = new ReentrantLock();
//    public static Condition condition = lock.newCondition();
    public static void main444(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Task task = new Task();
        Thread t1 = new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+"pre await ");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.write("11212");
            System.out.println("is over");
            countDownLatch.countDown();
        });
        Thread t2 = new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+" pre signalAll");
//            try {
//                TimeUnit.SECONDS.sleep(2000);
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            task.read();
            System.out.println(Thread.currentThread().getName()+" post signalAll");
            countDownLatch.countDown();
        });
        t1.start();
        t2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("这是测试");
    }


    public static void main44(String[] args) {
        int count = 0;
        retry:
        for(;;) {
            if (count < 10) {
                count++;
            } else {
                count = 0;
                break retry;
            }
            System.out.println(count);
        }
        System.err.println(count);
    }

    public static void main22(String[] args) {
        System.out.println(aa(entity-> {
            return entity+"hello world";
        },10));

        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(Thread.currentThread().getName());
        thread.start();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,60, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(100),new NameThreadFactory1("ceshi"));

        threadPoolExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
        threadPoolExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
        threadPoolExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
        threadPoolExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });

        Future<String> futureTask = threadPoolExecutor.submit(()->{
            System.out.println(Thread.currentThread().getName());
            URL url = new URL("http://www.baidu.com");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            OutputStream os = urlConnection.getOutputStream();
            InputStream is = urlConnection.getInputStream();
            byte[] bytes = new byte[0];
            bytes = new byte[is.available()];
            is.read(bytes);
            String str = new String(bytes);
            System.out.println(str);
           return "nihao";
        });
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(threadPoolExecutor.shutdownNow());
    }


    static class NameThreadFactory1 implements ThreadFactory{

        private AtomicInteger count = new AtomicInteger(1);

        private String name;
        public NameThreadFactory1(String name){
            this.name = name;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName(this.name+"--"+count.getAndIncrement());
            thread.setDaemon(false);
            thread.setPriority(5);
            return thread;
        }
    }
}
