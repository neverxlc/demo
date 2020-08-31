package com.example.demo.spi.impl;

public class SPIBServiceImpl implements SPIService {
    @Override
    public void execute() {
        System.out.println("B 执行了");
    }
}
