package com.example.demo.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration2 implements InitializingBean, DisposableBean {

    public MyConfiguration2() {
        System.out.println("MyConfiguration2 构造方法被调用");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyConfiguration2#destroy 被调用");

    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("MyConfiguration2#afterPropertiesSet 被调用");
    }
}
