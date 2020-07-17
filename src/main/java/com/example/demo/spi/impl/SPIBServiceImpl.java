package com.example.demo.spi.impl;

import com.example.demo.spi.SPIService;

public class SPIBServiceImpl implements SPIService {
    @Override
    public void execute() {
        System.out.println("B 执行了");
    }
}
