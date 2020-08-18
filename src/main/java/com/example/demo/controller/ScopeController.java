package com.example.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scope")
@Scope("prototype")//singleton  prototype
public class ScopeController {


    private int num = 0;

    @GetMapping(value = "/get01")
    public Object getScope() {
//        System.out.println(++num);
        return ++num;
    }


    @GetMapping(value = "/get02")
    public Object getScope2(){
//        System.out.println(++num);
        return ++num;
    }
}
