package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class MyConfiguration {

    public MyConfiguration(){
        System.out.println("MyConfiguration 构造方法执行");
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct 注解方法被调用");
    }

    @PreDestroy
    public void destory(){
        System.out.println("PreDestroy 注解方法被调用");
    }
}
