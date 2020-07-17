package com.example.demo.spi.impl;

import com.example.demo.spi.SPIService;

public class SPIAServiceImpl implements SPIService {
    @Override
    public void execute() {
        System.out.println("A 执行了");
    }
}
