package com.example.demo.controller;

import com.example.demo.exception.BusinessExcepption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "hctym")
public class HelloWorldController {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @GetMapping(value = "hi")
    public String hi() {
//        try {
//            String name = "你好,世界";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        int a = 1/0;
//        Assert.hasLength("", "params must not null");
        System.out.println("assssssssssssssssssssss");
        System.out.println(this.name);
        if (!this.name.equals("xlcc")) {
            throw new BusinessExcepption("1222","ceshiRes");
        }
        return "hi world";
    }

}
