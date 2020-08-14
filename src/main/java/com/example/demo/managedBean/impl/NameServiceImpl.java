package com.example.demo.managedBean.impl;

import com.example.demo.managedBean.NameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

@Named
public class NameServiceImpl implements NameService {

    private Logger logger = LoggerFactory.getLogger(NameService.class);

    @Override
    public void test() {
        String name = "Named";
        logger.info("测试test:{}",name);
        System.err.println("dddddddddddddddddddddd");
    }
}
