package com.example.demo.spi.impl;

public class SPIBServiceImpl implements com.example.demo.spi.SPIService {
    @Override
    public void execute() {
        System.out.println("B 执行了");
    }
}
