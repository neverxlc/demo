package com.example.demo.repository;

import com.alibaba.druid.filter.FilterManager;

import java.io.IOException;
import java.util.Properties;

public class FilterManagerDemo {


    public static void main(String[] args) throws IOException {
        Properties properties = FilterManager.loadFilterConfig();
       properties.forEach((key, value)->{
           System.out.println(key+": "+value);
       });
    }
}
