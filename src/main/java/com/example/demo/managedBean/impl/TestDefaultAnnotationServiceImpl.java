package com.example.demo.managedBean.impl;

import com.example.demo.annotation.TestComponent;
import com.example.demo.managedBean.TestDefaultAnnotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@TestComponent("defaultComponent")
public class TestDefaultAnnotationServiceImpl implements TestDefaultAnnotationService {
    private Logger logger = LoggerFactory.getLogger(TestDefaultAnnotationService.class);


    @Override
    public void demo() {
        String managedBean = "自定义注解";
        logger.info("测试demo,{}", managedBean);
        System.err.println("EEEEEEEEEEEEEEEEEEEEEEEEEEE");
//        ApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();

    }
}
