package com.example.demo;

import com.example.demo.domain.User;

import java.io.IOException;
import java.util.*;

public class Demo {

    public static void main11(String[] args) throws IOException {
//        String[] str = new String[2];
//        System.out.println(str[0]);
//        System.out.println(str[1]);
//        System.out.println(16>>2);
//        System.err.println(DemoApplication.class.isAnnotationPresent(SpringBootApplication.class));
//        System.err.println(DemoApplication.class.isInterface());
//
//        ClassLoader classLoader = Demo.class.getClassLoader();
//        Enumeration<URL> urls = classLoader.getResources("META-INF/services/com.example.demo.spi.SPIService");
//        System.out.println(urls.hasMoreElements());
//        while (urls.hasMoreElements()) {
//            System.out.println(urls.nextElement());
//        }
//        ServiceLoader<SPIService> serviceLoader = ServiceLoader.load(SPIService.class);

//        Properties properties = new Properties();
//        properties.getProperty("user.age","0");
//        properties.getProperty("user.home");
//        System.out.println(System.getProperty("user.age","0"));
//        System.out.println(System.getProperty("user.home"));
//        Map<String, String> map = System.getenv();
//        for (Map.Entry<String,String> entry: map.entrySet()) {
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }
//        System.out.println(System.getenv());
        demo001();
    }


    public static void demo001(){

        Map<String, User> map = new HashMap<>();
//        map.put("xlc", )
//        map.putIfAbsent("xlc", User.builder().name("xlc").build());

        System.out.println(map);
    }

    public static void main(String[] args) {

        String name = "com.example.demo.Xlc";
        ClassLoader classLoader = Demo.class.getClassLoader();
        ClassLoader threadClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Class<?> nameClass = threadClassLoader.loadClass(name);
            System.out.println(String.format("Driver class %S found in Thread context class loader %S", nameClass, threadClassLoader));
        } catch (ClassNotFoundException e) {
//            System.out.println(MessageFormat.format("Driver class {} not found in Thread context class loader {}, trying classloader {}", name, threadClassLoader, Demo.class.getClassLoader()));
            e.printStackTrace();
        }
    }
}
