package com.example.demo.managedBean.impl;

import com.example.demo.managedBean.ScannerService;
import com.example.demo.managedBean.TestDefaultAnnotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.ManagedBean;

@ManagedBean
public class ScannerServiceImpl implements ScannerService {

    private Logger logger = LoggerFactory.getLogger(ScannerServiceImpl.class);

    @Autowired
    WebApplicationContext webApplicationConnect;

    @Override
    public void walk() {
        String managedBean = "@ManagedBean";
        logger.info("测试demo,{}", managedBean);
        System.err.println("cccccccccccccccccccccccccc");
        TestDefaultAnnotationService service = (TestDefaultAnnotationService) webApplicationConnect.getBean("defaultComponent");
        service.demo();
        System.out.println("aaaaaaa");
    }
}
