package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @GetMapping("/getAll")
//    @ResponseBody
    public Object getAll(){
        User user = new User();
//        user.setId(1L);
//        user.setName("许林创");
//        user.setAge(211);
//        user.setSex(1);
//        return Arrays.asList(user, User.builder()
//                .name("aaa").age(1).id(2L).build());
        return "getALL";
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Object insert(){

        return "Success";
    }
}
