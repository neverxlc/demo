package com.example.demo.managedBean.impl;

import com.example.demo.managedBean.ScannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.ManagedBean;

@ManagedBean
public class ScannerServiceImpl implements ScannerService {

    private Logger logger = LoggerFactory.getLogger(ScannerServiceImpl.class);

    @Override
    public void walk() {
        String managedBean = "@ManagedBean";
        logger.info("测试demo,{}", managedBean);
        System.err.println("cccccccccccccccccccccccccc");
    }
}
