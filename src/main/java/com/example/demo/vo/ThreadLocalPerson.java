package com.example.demo.vo;

public class ThreadLocalPerson {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void setPerson(String name){
        threadLocal.set(name);
    }

    public static String getPerson() {
       return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }


    public static void main(String[] args) {

        int size = 0;
        System.out.println(size);
//        ThreadLocalPerson.setPerson("hctym");
//        Thread thread = new Thread(()->{
//            ThreadLocalPerson.setPerson("xlc");
//            System.out.println(Thread.currentThread().getName()+"===" + ThreadLocalPerson.getPerson());
//        });
//        thread.start();
//        System.out.println(Thread.currentThread().getName()+"===" + ThreadLocalPerson.getPerson());

    }
}
