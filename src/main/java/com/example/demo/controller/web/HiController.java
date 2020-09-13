package com.example.demo.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HiController {

    @RequestMapping("/")
    public String index() {
        return "index001";
    }

    @RequestMapping("/hello")
    public String hi() {
        return "hello001";
    }


    @RequestMapping("/login")
    public String login() {
        return "login001";
    }
}
